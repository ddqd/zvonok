package com.cryptocommune.domain.usecase;

import com.cryptocommune.domain.schedulers.ObserveOn;
import com.cryptocommune.domain.schedulers.SubscribeOn;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Dema on 24.09.2016.
 */

public abstract class BaseUseCase<T> {

    private ObserveOn observeOn;
    private SubscribeOn subscribeOn;

    BaseUseCase(SubscribeOn subscribeOn, ObserveOn observeOn) {
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }

    public Subscription execute(Subscriber<T> subscriber) {
        return buildUseCaseObservable()
                .subscribeOn(subscribeOn.getScheduler())
                .observeOn(observeOn.getScheduler())
                .subscribe(subscriber);
    }

    protected abstract Observable<T> buildUseCaseObservable();
}
