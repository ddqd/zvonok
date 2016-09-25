package org.cryptocommune.zvonok.di;

import com.cryptocommune.domain.repository.ZvonokRepository;

import org.cryptocommune.data.repository.ZvonokMockRepository;
import org.cryptocommune.data.repository.ZvonokNetworkRepository;
import org.cryptocommune.data.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dema on 24.09.2016.
 */

@Module(includes = NetworkModule.class)
public class RepositoryModule {
    private final boolean isMock;

    public RepositoryModule(boolean isMock) {
        this.isMock = isMock;
    }

    @Provides
    @Singleton
    ZvonokRepository provideZvonokRepository(ZvonokMockRepository zvonokMockRepository, ZvonokNetworkRepository zvonokNetworkRepository) {
        return isMock ? zvonokMockRepository : zvonokNetworkRepository;
    }
}
