package com.prasad.socialnetworkandroidmvvm.di.builder;

import com.prasad.socialnetworkandroidmvvm.ui.main.MainActivity;
import com.prasad.socialnetworkandroidmvvm.ui.login.LoginActivity;
import com.prasad.socialnetworkandroidmvvm.ui.register.RegisterActivity;
import com.prasad.socialnetworkandroidmvvm.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created By Prasad on 2020-05-23.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract RegisterActivity bindRegisterActivity();
}
