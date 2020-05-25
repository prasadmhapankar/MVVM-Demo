package com.prasad.socialnetworkandroidmvvm.di.module;

import com.prasad.socialnetworkandroidmvvm.BuildConfig;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By Prasad on 2020-05-24.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .client(providesOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static SocialNetworkService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(SocialNetworkService.class);
    }

    @Provides
    @Singleton
    static OkHttpClient providesOkHttpClient() {

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
        return client.build();
    }

}
