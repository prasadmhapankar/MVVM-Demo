package com.prasad.socialnetworkandroidmvvm.di.builder

import com.prasad.socialnetworkandroidmvvm.ui.main.posts.PostsFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created By Prasad on 2020-05-26.
 */


@Module(subcomponents = [MainFragmentSubcomponent::class])
abstract class FragmentBuilder {
    @Binds
    @IntoMap
    @ClassKey(PostsFragment::class)
    abstract fun bindYourAndroidInjectorFactory(factory: MainFragmentSubcomponent.Factory)
            : AndroidInjector.Factory<*>
}