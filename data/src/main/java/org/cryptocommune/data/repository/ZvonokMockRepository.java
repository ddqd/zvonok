package org.cryptocommune.data.repository;

import com.cryptocommune.domain.repository.ZvonokRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Dema on 24.09.2016.
 */

@Singleton
public class ZvonokMockRepository implements ZvonokRepository {

    @Inject
    public ZvonokMockRepository() {}

    @Override
    public Observable<Void> ring(String message) {
        return Observable.just(null);
    }
}
