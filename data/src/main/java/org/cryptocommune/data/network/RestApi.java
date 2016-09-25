package org.cryptocommune.data.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Dema on 09.01.2016.
 */

@Singleton
public class RestApi {
    private final Endpoints endpoints;

    public RestApi(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    public Observable<Boolean> ring() {
        return endpoints.ring();
    }
}