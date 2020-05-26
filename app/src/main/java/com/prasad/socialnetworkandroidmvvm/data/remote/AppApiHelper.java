package com.prasad.socialnetworkandroidmvvm.data.remote;

import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created By Prasad on 2020-05-24.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private SocialNetworkService mNetworkService;

    @Inject
    public AppApiHelper(SocialNetworkService networkService) {
        mNetworkService =  networkService;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mNetworkService.loginUser(request.getUserId());
    }

    @Override
    public Single<RegisterResponse> doServerRegisterApiCall(RegisterRequest.ServerRegisterRequest request) {
        return mNetworkService.registerNewUser(request);
    }

    @Override
    public Single<PostsResponse> getPostsApiCall(PostsRequest request) {
        return mNetworkService.getPosts(request);
    }

}
