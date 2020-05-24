package com.prasad.socialnetworkandroidmvvm.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created By Prasad on 2020-05-23.
 */


public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
