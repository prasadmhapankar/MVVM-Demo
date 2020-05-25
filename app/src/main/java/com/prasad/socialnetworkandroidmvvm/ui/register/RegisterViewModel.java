package com.prasad.socialnetworkandroidmvvm.ui.register;

import android.text.TextUtils;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.RegisterRequest;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.CommonUtils;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

/**
 * Created By Prasad on 2020-05-24.
 */


public class RegisterViewModel extends BaseViewModel<RegisterNavigator> {
    public RegisterViewModel(SocialNetworkService networkService, DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(networkService, dataManager, schedulerProvider);
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

    public void register(String firstname, String lastname, String email, String gender) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerRegisterApiCall(new RegisterRequest.ServerRegisterRequest(firstname, lastname, email, gender))
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

    public void onRegisterClick() {
        getNavigator().register();
    }
}
