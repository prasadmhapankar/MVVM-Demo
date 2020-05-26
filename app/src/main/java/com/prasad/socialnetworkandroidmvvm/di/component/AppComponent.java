package com.prasad.socialnetworkandroidmvvm.di.component;

import android.app.Application;

import com.prasad.socialnetworkandroidmvvm.MainApplication;
import com.prasad.socialnetworkandroidmvvm.di.builder.ActivityBuilder;
import com.prasad.socialnetworkandroidmvvm.di.builder.FragmentBuilder;
import com.prasad.socialnetworkandroidmvvm.di.module.AppModule;
import com.prasad.socialnetworkandroidmvvm.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created By Prasad on 2020-05-23.
 */


@Singleton
@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class,
        AppModule.class, NetworkModule.class, ActivityBuilder.class, FragmentBuilder.class})
public interface AppComponent {

    void inject(MainApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
