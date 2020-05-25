package com.prasad.socialnetworkandroidmvvm.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.prasad.socialnetworkandroidmvvm.BuildConfig;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
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

        client.addNetworkInterceptor(new StethoInterceptor());

        return client.build();
    }

}
