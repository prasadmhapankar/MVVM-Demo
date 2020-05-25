package com.prasad.socialnetworkandroidmvvm.data.remote;

import com.prasad.socialnetworkandroidmvvm.BuildConfig;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface SocialNetworkService {

    @GET("users/{userId}?_format=json&access-token=" + BuildConfig.ACCESS_TOKEN)
    Single<LoginResponse> loginUser(@Path("userId") String userId);
}
