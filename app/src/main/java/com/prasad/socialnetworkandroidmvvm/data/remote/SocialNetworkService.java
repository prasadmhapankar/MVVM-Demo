package com.prasad.socialnetworkandroidmvvm.data.remote;

import com.prasad.socialnetworkandroidmvvm.BuildConfig;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface SocialNetworkService {

    @GET("users/{userId}?_format=json&access-token=" + BuildConfig.ACCESS_TOKEN)
    Single<LoginResponse> loginUser(@Path("userId") String userId);

    @Headers({
            "Accept:application/json",
            "Content-Type: application/json",
            "Authorization: Bearer " + BuildConfig.ACCESS_TOKEN,
    })
    @POST("users")
    Single<RegisterResponse> registerNewUser(@Body RegisterRequest.ServerRegisterRequest registerRequest);

    @GET("posts?_format=json&access-token=" + BuildConfig.ACCESS_TOKEN)
    Single<PostsResponse> getPosts(@Query("page") PostsRequest page);
}
