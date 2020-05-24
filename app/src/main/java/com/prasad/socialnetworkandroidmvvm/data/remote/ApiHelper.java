package com.prasad.socialnetworkandroidmvvm.data.remote;

import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;

import io.reactivex.Single;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface ApiHelper {

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

}
