package com.prasad.socialnetworkandroidmvvm.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.prasad.socialnetworkandroidmvvm.R;
import com.prasad.socialnetworkandroidmvvm.ViewModelProviderFactory;
import com.prasad.socialnetworkandroidmvvm.databinding.ActivitySplashBinding;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseActivity;
import com.prasad.socialnetworkandroidmvvm.ui.login.LoginActivity;
import com.prasad.socialnetworkandroidmvvm.ui.main.MainActivity;

import javax.inject.Inject;

import static com.prasad.socialnetworkandroidmvvm.BR.viewModel;

/**
 * Created By Prasad on 2020-05-23.
 */


public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;

    private SplashViewModel mSplashViewModel;

    @Override
    public int getBindingVariable() {
        return viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this,factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.startApp();
    }
}
