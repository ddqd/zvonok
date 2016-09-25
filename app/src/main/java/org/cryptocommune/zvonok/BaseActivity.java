package org.cryptocommune.zvonok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.cryptocommune.zvonok.di.ApplicationComponent;

/**
 * Created by Dema on 24.09.2016.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }
}
