package org.cryptocommune.zvonok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cryptocommune.domain.usecase.RingUseCase;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Dema on 24.09.2016.
 */

public class ZvonokFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = ZvonokFragment.class.getName();

    public static final String RING_BUTTON_ENABLED = "RING_BUTTON_ENABLED";

    @Inject
    RingUseCase ringUseCase;

    private Subscription subscription = Subscriptions.empty();

    public static Fragment create() {
        ZvonokFragment zvonokFragment = new ZvonokFragment();
        return zvonokFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBaseActivity().getApplicationComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zvonok, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View ringButton = view.findViewById(R.id.b_ring);
        ringButton.setOnClickListener(this);
        if (savedInstanceState != null) {
            boolean isEnabled = savedInstanceState.getBoolean(RING_BUTTON_ENABLED, true);
            if (!isEnabled) {
                startDisableRingButton();
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_ring:
                startRing();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null)
            subscription.unsubscribe();
    }

    private void startRing() {
        subscription = ringUseCase
                .setMessage("imvedroid")
                .execute(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(getView(), "error: " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(Void v) {
                        Snackbar.make(getView(), getString(R.string.ring_ring), Snackbar.LENGTH_LONG).show();
                        startDisableRingButton();
                    }

                });
    }


    private void startDisableRingButton() {
        setRingButtonEnabled(false);
        Observable.timer(5, TimeUnit.SECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {
                    setRingButtonEnabled(true);
                });
    }

    private void setRingButtonEnabled(boolean enabled) {
        getView().findViewById(R.id.b_ring).setEnabled(enabled);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean value = getView().findViewById(R.id.b_ring).isEnabled();
        outState.putBoolean(RING_BUTTON_ENABLED, value);
        super.onSaveInstanceState(outState);
    }
}
