package com.prasad.socialnetworkandroidmvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;
import com.prasad.socialnetworkandroidmvvm.ui.login.LoginViewModel;
import com.prasad.socialnetworkandroidmvvm.ui.main.MainViewModel;
import com.prasad.socialnetworkandroidmvvm.ui.register.RegisterViewModel;
import com.prasad.socialnetworkandroidmvvm.ui.splash.SplashViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created By Prasad on 2020-05-23.
 */

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory{

    private final SocialNetworkService networkService;
    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(SocialNetworkService networkService, DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.networkService = networkService;
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(networkService, dataManager,schedulerProvider);
        }else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(networkService, dataManager,schedulerProvider);
        } else if(modelClass.isAssignableFrom(RegisterViewModel.class)) {
            //noinspection unchecked
            return (T) new RegisterViewModel(networkService, dataManager,schedulerProvider);
        }else if(modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(networkService, dataManager,schedulerProvider);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
