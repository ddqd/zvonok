package org.cryptocommune.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by dema on 22.06.15.
 */

@Module
public class NetworkModule {

    private static final String BASE_URL = "http://z.puk/";

    @Provides
    Endpoints provideEndpoints() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(providesGson()))
                .build();
        return retrofit.create(Endpoints.class);
    }

    @Provides
    @Singleton
    RestApi provideRestApi(Endpoints endpoints) {
        return new RestApi(endpoints);
    }

    private static Gson providesGson() {
        return new GsonBuilder().create();
    }

    private static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }


}
