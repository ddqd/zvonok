package org.cryptocommune.data.network;

import javax.inject.Singleton;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by Dema on 09.01.2016.
 */

@Singleton
public class RestApi {
    private final Endpoints endpoints;

    RestApi(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    public Observable<Void> ring(final String message) {
        return endpoints.ring(RequestBody.create(MediaType.parse("text/plain"), message));
    }
}