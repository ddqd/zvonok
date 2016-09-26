package org.cryptocommune.data.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface Endpoints {
    @Headers({
            "Accept-Encoding: gzip, deflate",
            "Accept: */*",
            "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4"
    })
    @FormUrlEncoded
    @POST("doorbell")
    Observable<Void> ring(@Field(value = "text", encoded = true) String message);
}
