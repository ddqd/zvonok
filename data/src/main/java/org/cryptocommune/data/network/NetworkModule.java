package org.cryptocommune.data.network;

import android.util.Log;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by dema on 22.06.15.
 */

@Module
public class NetworkModule {

    private static OkHttpClient provideOkHttpClient(boolean isLogEnabled) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (isLogEnabled) {
            builder.addInterceptor(new HttpLoggingInterceptor(message -> Log.d("okhttp", message)).setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.build();
    }

    @Provides
    Endpoints provideEndpoints(final @Named("host") String host, @Named("isDebug") boolean isDebug) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(provideOkHttpClient(isDebug))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(Endpoints.class);
    }

    @Provides
    @Singleton
    RestApi provideRestApi(Endpoints endpoints) {
        return new RestApi(endpoints);
    }


}
