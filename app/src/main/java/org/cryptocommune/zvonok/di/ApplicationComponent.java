package org.cryptocommune.zvonok.di;

import android.content.Context;

import com.cryptocommune.domain.repository.ZvonokRepository;
import com.cryptocommune.domain.schedulers.ObserveOn;
import com.cryptocommune.domain.schedulers.SubscribeOn;

import org.cryptocommune.zvonok.MainActivity;
import org.cryptocommune.zvonok.ZvonokFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dema on 24.09.2016.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
    void inject(ZvonokFragment fragment);

    Context context();
    SubscribeOn subscribeOn();
    ObserveOn observeOn();
    ZvonokRepository zvonokRepository();
}