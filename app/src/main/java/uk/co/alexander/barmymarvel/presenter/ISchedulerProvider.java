package uk.co.alexander.barmymarvel.presenter;

import io.reactivex.Scheduler;


public interface ISchedulerProvider {
    Scheduler provideSubscribeScheduler() ;
    Scheduler provideObserveScheduler() ;
}
