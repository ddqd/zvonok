package org.cryptocommune.data.network;

import retrofit.http.POST;
import rx.Observable;

public interface Endpoints {
    @POST("doorbell")
    Observable<Boolean> ring();
}
