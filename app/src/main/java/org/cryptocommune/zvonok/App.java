package org.cryptocommune.zvonok;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import org.cryptocommune.zvonok.di.ApplicationComponent;
import org.cryptocommune.zvonok.di.ApplicationModule;
import org.cryptocommune.zvonok.di.DaggerApplicationComponent;
import org.cryptocommune.zvonok.di.RepositoryModule;

/**
 * Created by Dema on 24.09.2016.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;
    private boolean B;

    @Override
    public void onCreate() {
        super.onCreate();
        if (!isCI()) {
            LeakCanary.install(this);
        }
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .repositoryModule(new RepositoryModule(isCI()))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public String getHost() {
        return BuildConfig.host;
    }

    public boolean isCI() {
        return BuildConfig.CI;
    }

    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
