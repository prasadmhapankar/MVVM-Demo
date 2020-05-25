package com.prasad.socialnetworkandroidmvvm.ui.login;

import android.text.TextUtils;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

import timber.log.Timber;

/**
 * Created By Prasad on 2020-05-23.
 */


public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public final String TAG = "LoginViewModel";
    public LoginViewModel(SocialNetworkService networkService, DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(networkService, dataManager, schedulerProvider);
    }

    public boolean isUserIdValid(String userId) {
        // validate email and password
        if (TextUtils.isEmpty(userId)) {
            return false;
        }
        try{
            Integer.parseInt(userId);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void login(String userId) {
        setIsLoading(true);
        Timber.d(userId);
        getCompositeDisposable().add(getDataManager().doServerLoginApiCall(new LoginRequest.ServerLoginRequest(userId))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response ->{
                    setIsLoading(false);
                    if(response.getMeta() != null && response.getMeta().getStatus()){
                        getDataManager().updateUserInfo(
                                response.getResult().getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getResult().getFirstName(),
                                response.getResult().getLastName(),
                                response.getResult().getUserEmail());
                        getNavigator().openMainActivity();
                    } else {
                        getNavigator().handleError(null);
                    }
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));

    }

    public void signUpNow() {
        getNavigator().openRegisterActivity();
    }

    public void onLoginClick() {
        getNavigator().login();
    }

    public void onSignUpNowClick() {
        getNavigator().signUpNow();
    }
}
