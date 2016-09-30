package com.cryptocommune.domain.repository;

import rx.Observable;

/**
 * Created by Dema on 24.09.2016.
 */

public interface ZvonokRepository {
    Observable<Boolean> ring(final String message);
}
