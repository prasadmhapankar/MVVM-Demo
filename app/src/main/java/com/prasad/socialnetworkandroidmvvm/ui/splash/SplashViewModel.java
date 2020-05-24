package com.prasad.socialnetworkandroidmvvm.ui.splash;

import android.os.Handler;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

/**
 * Created By Prasad on 2020-05-23.
 */


public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void startApp() {
        decideNextActivity();
    }

    private void decideNextActivity() {

        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openMainActivity();
        }

    }
}
