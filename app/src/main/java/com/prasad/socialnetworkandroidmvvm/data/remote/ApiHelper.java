package com.prasad.socialnetworkandroidmvvm.data.remote;

import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterResponse;

import io.reactivex.Single;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface ApiHelper {

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<RegisterResponse> doServerRegisterApiCall(RegisterRequest.ServerRegisterRequest request);

    Single<PostsResponse> getPostsApiCall(PostsRequest request);

}
