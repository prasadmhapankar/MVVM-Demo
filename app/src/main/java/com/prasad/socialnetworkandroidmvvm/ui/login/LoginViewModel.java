package com.prasad.socialnetworkandroidmvvm.ui.login;

import android.text.TextUtils;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.CommonUtils;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

/**
 * Created By Prasad on 2020-05-23.
 */


public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        //setIsLoading(true);
        getNavigator().openMainActivity();
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
