package org.cryptocommune.zvonok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag(ZvonokFragment.TAG);
            if (fragment == null) {
                fragment = ZvonokFragment.create();
            }
            fm.beginTransaction().replace(R.id.container, fragment, ZvonokFragment.TAG).commit();
        }
    }
}
