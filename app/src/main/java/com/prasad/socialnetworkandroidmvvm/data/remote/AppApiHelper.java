package com.prasad.socialnetworkandroidmvvm.data.remote;

import com.prasad.socialnetworkandroidmvvm.BuildConfig;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created By Prasad on 2020-05-24.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    private SocialNetworkService mNetworkService;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, SocialNetworkService networkService) {
        mApiHeader = apiHeader;
        mNetworkService =  networkService;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mNetworkService.loginUser(request.getUserId());
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
