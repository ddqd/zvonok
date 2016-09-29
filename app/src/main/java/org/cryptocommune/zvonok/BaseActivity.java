package org.cryptocommune.zvonok;

import android.os.Bundle;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import org.cryptocommune.zvonok.di.ApplicationComponent;

/**
 * Created by Dema on 24.09.2016.
 */

public class BaseActivity extends RxAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }
}
