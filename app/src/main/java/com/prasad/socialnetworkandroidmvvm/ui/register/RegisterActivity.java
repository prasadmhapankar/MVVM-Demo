package com.prasad.socialnetworkandroidmvvm.ui.register;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.prasad.socialnetworkandroidmvvm.R;
import com.prasad.socialnetworkandroidmvvm.ViewModelProviderFactory;
import com.prasad.socialnetworkandroidmvvm.databinding.ActivityRegisterBinding;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseActivity;
import com.prasad.socialnetworkandroidmvvm.ui.main.MainActivity;

import javax.inject.Inject;


import static com.prasad.socialnetworkandroidmvvm.BR.viewModel;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> implements RegisterNavigator{

    @Inject
    ViewModelProviderFactory factory;
    private RegisterViewModel mRegisterViewModel;
    private ActivityRegisterBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterViewModel getViewModel() {
        mRegisterViewModel = ViewModelProviders.of(this,factory).get(RegisterViewModel.class);
        return mRegisterViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mRegisterViewModel.setNavigator(this);
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(this, getString(R.string.invalid_register_details), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void register() {
        String firstname = mActivityLoginBinding.inputFirstName.getText().toString();
        String lastname = mActivityLoginBinding.inputLastName.getText().toString();
        String email = mActivityLoginBinding.inputEmail.getText().toString();
        String gender = mActivityLoginBinding.rbMale.isChecked() ?
                mActivityLoginBinding.rbMale.getText().toString() : mActivityLoginBinding.rbFemale.getText().toString();
        if (mRegisterViewModel.isRegisterDetailsValid(firstname, lastname, email, gender.toLowerCase())) {
            hideKeyboard();
            mRegisterViewModel.register(firstname, lastname, email, gender.toLowerCase());
        } else {
            Toast.makeText(this, getString(R.string.invalid_register_details), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(RegisterActivity.this);
        startActivity(intent);
        finish();
    }

}
