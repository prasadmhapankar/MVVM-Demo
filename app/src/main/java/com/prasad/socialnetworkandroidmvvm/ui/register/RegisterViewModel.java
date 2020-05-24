package com.prasad.socialnetworkandroidmvvm.ui.register;

import android.text.TextUtils;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.CommonUtils;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

/**
 * Created By Prasad on 2020-05-24.
 */


public class RegisterViewModel extends BaseViewModel<RegisterNavigator> {
    public RegisterViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isRegisterDetailsValid(String firstname, String lastname, String email, String password) {
        // validate register details
        if (TextUtils.isEmpty(firstname)) {
            return false;
        }
        if (TextUtils.isEmpty(lastname)) {
            return false;
        }
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

    public void register(String firstname, String lastname, String email, String password) {
        //setIsLoading(true);
        getNavigator().openMainActivity();
    }

    public void onRegisterClick() {
        getNavigator().register();
    }
}
