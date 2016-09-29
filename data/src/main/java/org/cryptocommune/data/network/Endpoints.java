package org.cryptocommune.data.network;

import okhttp3.RequestBody;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public interface Endpoints {
    @Headers({
            "Accept: */*",
            "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4"
    })
    @Multipart
    @POST("doorbell")
    Observable<Void> ring(@Part("text") final RequestBody text);
}
