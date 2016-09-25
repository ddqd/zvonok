package com.cryptocommune.domain.usecase;

import com.cryptocommune.domain.repository.ZvonokRepository;
import com.cryptocommune.domain.schedulers.ObserveOn;
import com.cryptocommune.domain.schedulers.SubscribeOn;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Dema on 24.09.2016.
 */

public class RingUseCase extends BaseUseCase<Boolean> {

    private ZvonokRepository zvonokRepository;

    @Inject
    RingUseCase(SubscribeOn subscribeOn, ObserveOn observeOn, ZvonokRepository zvonokRepository) {
        super(subscribeOn, observeOn);
        this.zvonokRepository = zvonokRepository;
    }

    @Override
    protected Observable<Boolean> buildUseCaseObservable() {
        return zvonokRepository.ring();
    }
}
