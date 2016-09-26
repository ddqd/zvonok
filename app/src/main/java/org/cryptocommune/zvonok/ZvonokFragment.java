package org.cryptocommune.zvonok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cryptocommune.domain.usecase.RingUseCase;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Dema on 24.09.2016.
 */

public class ZvonokFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = ZvonokFragment.class.getName();

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
        View button = view.findViewById(R.id.b_ring);
        button.setOnClickListener(this);
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
                Snackbar.make(getView(), "error " + e.getMessage(), Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onNext(Void aBoolean) {
                Snackbar.make(getView(), "succes " + aBoolean, Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
