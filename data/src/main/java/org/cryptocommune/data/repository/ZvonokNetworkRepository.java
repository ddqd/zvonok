package org.cryptocommune.data.repository;

import com.cryptocommune.domain.repository.ZvonokRepository;

import org.cryptocommune.data.network.RestApi;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Dema on 24.09.2016.
 */

@Singleton
public class ZvonokNetworkRepository implements ZvonokRepository {

    RestApi restApi;

    @Inject
    public ZvonokNetworkRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<Void> ring(final String message) {
        return restApi.ring(message);
    }
}
