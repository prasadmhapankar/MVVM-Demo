package com.prasad.socialnetworkandroidmvvm.ui.login;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.LoginResponse;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;
import com.prasad.socialnetworkandroidmvvm.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created By Prasad on 2020-05-25.
 */


@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    @Mock
    LoginNavigator mLoginCallback;
    @Mock
    DataManager mMockDataManager;
    @Mock
    SocialNetworkService mSocialNetworkService;
    private LoginViewModel mLoginViewModel;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginViewModel = new LoginViewModel(mSocialNetworkService, mMockDataManager, testSchedulerProvider);
        mLoginViewModel.setNavigator(mLoginCallback);
    }

    @After
    public void tearDown() throws Exception {
        mTestScheduler = null;
        mLoginViewModel = null;
        mLoginCallback = null;
    }

    @Test
    public void testServerLoginSuccess() {
        String userId = "1648";

        LoginResponse loginResponse = new LoginResponse();

        doReturn(Single.just(loginResponse))
                .when(mMockDataManager)
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(userId));

        mLoginViewModel.login(userId);
        mTestScheduler.triggerActions();

        verify(mLoginCallback).openMainActivity();
    }
}
