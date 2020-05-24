package com.prasad.socialnetworkandroidmvvm.data.remote;

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

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return null;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
