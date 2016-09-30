package org.cryptocommune.zvonok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Created by Dema on 24.09.2016.
 */

public class BaseFragment extends RxFragment {

    protected BaseActivity getBaseActivity() {
        if (getActivity() instanceof BaseActivity)
            return (BaseActivity) getActivity();
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar != null && getBaseActivity() != null) {
            getBaseActivity().setSupportActionBar(toolbar);
        }
    }
}
