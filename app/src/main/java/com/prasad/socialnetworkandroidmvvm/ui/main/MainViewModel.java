package com.prasad.socialnetworkandroidmvvm.ui.main;

import android.text.TextUtils;

import androidx.databinding.ObservableField;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

/**
 * Created By Prasad on 2020-05-25.
 */


public class MainViewModel extends BaseViewModel<MainNavigator> {


    private final ObservableField<String> userName = new ObservableField<>();

    private final ObservableField<String> userEmail = new ObservableField<>();

    public MainViewModel(SocialNetworkService networkService, DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(networkService, dataManager, schedulerProvider);
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }


    public void logout() {
        getDataManager().setUserAsLoggedOut();
        getNavigator().openLoginActivity();
    }

    public void onNavMenuCreated() {
        final String currentUserName = getDataManager().getCurrentFirstName() + " " + getDataManager().getCurrentLastName();
        if (!TextUtils.isEmpty(currentUserName)) {
            userName.set(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (!TextUtils.isEmpty(currentUserEmail)) {
            userEmail.set(currentUserEmail);
        }
    }
}
