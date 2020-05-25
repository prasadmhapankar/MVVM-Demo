package com.prasad.socialnetworkandroidmvvm.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.prasad.socialnetworkandroidmvvm.ViewModelProviderFactory;
import com.prasad.socialnetworkandroidmvvm.ui.main.MainActivity;
import com.prasad.socialnetworkandroidmvvm.R;
import com.prasad.socialnetworkandroidmvvm.databinding.ActivityLoginBinding;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseActivity;
import com.prasad.socialnetworkandroidmvvm.ui.register.RegisterActivity;

import javax.inject.Inject;

import static com.prasad.socialnetworkandroidmvvm.BR.viewModel;

/**
 * Created By Prasad on 2020-05-23.
 */


public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator{

    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
        Toast.makeText(this, getString(R.string.invalid_details), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        String userId = mActivityLoginBinding.inputUserId.getText().toString();
        if (mLoginViewModel.isUserIdValid(userId)) {
            hideKeyboard();
            mLoginViewModel.login(userId);
        } else {
            Toast.makeText(this, getString(R.string.invalid_details), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void signUpNow() {
        mLoginViewModel.signUpNow();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openRegisterActivity() {
        Intent intent = RegisterActivity.newIntent(LoginActivity.this);
        startActivity(intent);
       // finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }
}
