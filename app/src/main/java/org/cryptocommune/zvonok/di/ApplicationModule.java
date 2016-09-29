package org.cryptocommune.zvonok.di;

import android.content.Context;

import com.cryptocommune.domain.schedulers.ObserveOn;
import com.cryptocommune.domain.schedulers.SubscribeOn;

import org.cryptocommune.zvonok.App;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@Module
public class ApplicationModule {

    App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application;
    }

    @Provides
    SubscribeOn provideSubscribeOn() {
        return (() -> Schedulers.newThread());
    }

    @Provides
    ObserveOn provideObserveOn() {
        return (() -> AndroidSchedulers.mainThread());
    }

    @Provides
    @Named("host")
    String provideHostName() {
        return application.getHost();
    }

    @Provides
    @Named("isDebug")
    boolean provideIsDebug() {
        return application.isDebug();
    }
}
