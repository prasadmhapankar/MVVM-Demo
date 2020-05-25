package com.prasad.socialnetworkandroidmvvm.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;
import com.prasad.socialnetworkandroidmvvm.R;
import com.prasad.socialnetworkandroidmvvm.ViewModelProviderFactory;
import com.prasad.socialnetworkandroidmvvm.databinding.ActivityMainBinding;
import com.prasad.socialnetworkandroidmvvm.databinding.NavHeaderMainBinding;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseActivity;
import com.prasad.socialnetworkandroidmvvm.ui.login.LoginActivity;

import javax.inject.Inject;

import static com.prasad.socialnetworkandroidmvvm.BR.viewModel;
import static com.prasad.socialnetworkandroidmvvm.R.string.close_drawer;
import static com.prasad.socialnetworkandroidmvvm.R.string.open_drawer;

/**
 * Created By Prasad on 2020-05-25.
 */


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private ActivityMainBinding mActivityMainBinding;
    private MainViewModel mMainViewModel;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);
        setUp();
    }

    @Override
    public int getBindingVariable() {
        return viewModel;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return mMainViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(this));
        finish();
    }

    private void setUp() {
        mDrawer = mActivityMainBinding.drawerLayout;
        mToolbar = mActivityMainBinding.toolbar;
        mNavigationView = mActivityMainBinding.navView;
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                open_drawer,
                close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        setupNavMenu();
        mMainViewModel.onNavMenuCreated();
        //subscribeToLiveData();
    }

    private void setupNavMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, mActivityMainBinding.navView, false);
        mActivityMainBinding.navView.addHeaderView(navHeaderMainBinding.getRoot());
        navHeaderMainBinding.setViewModel(mMainViewModel);

        mNavigationView.setNavigationItemSelectedListener(
                item -> {
                    mDrawer.closeDrawer(GravityCompat.START);
                    switch (item.getItemId()) {
                        case R.id.nav_logout:
                            mMainViewModel.logout();
                            return true;
                        default:
                            return false;
                    }
                });
    }

}
