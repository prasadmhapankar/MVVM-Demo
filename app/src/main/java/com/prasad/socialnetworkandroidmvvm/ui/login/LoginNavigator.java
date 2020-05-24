package com.prasad.socialnetworkandroidmvvm.ui.login;

/**
 * Created By Prasad on 2020-05-23.
 */


public interface LoginNavigator {

    void handleError(Throwable throwable);

    void login();

    void signUpNow();

    void openMainActivity();

    void openRegisterActivity();
}
