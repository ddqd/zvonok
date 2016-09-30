package org.cryptocommune.data.network;

import javax.inject.Singleton;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
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

    public Observable<Boolean> ring(final String message) {
        Observable<Response<ResponseBody>> res = endpoints.ring(RequestBody.create(MediaType.parse("text/plain"), message));
        return res.map(r -> r.code() == 200);
    }
}