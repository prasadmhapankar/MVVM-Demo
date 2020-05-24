package com.prasad.socialnetworkandroidmvvm.ui.register;

/**
 * Created By Prasad on 2020-05-24.
 */


public interface RegisterNavigator {
    void handleError(Throwable throwable);

    void register();

    void openMainActivity();
}
