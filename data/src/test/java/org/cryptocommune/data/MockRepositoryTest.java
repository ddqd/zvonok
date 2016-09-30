package org.cryptocommune.data;

import org.cryptocommune.data.repository.ZvonokMockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import rx.observers.TestSubscriber;

@RunWith(RxJavaTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MockRepositoryTest {

    @Test
    public void testMockZvonokRepositoryTrue() throws Exception {
        TestSubscriber<Boolean> testSubscriber = new TestSubscriber<>();
        ZvonokMockRepository zvonokMockRepository = new ZvonokMockRepository();
        zvonokMockRepository.ring("test").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Arrays.asList(true));
    }

    @Test
    public void testMockZvonokRepositoryFalse() throws Exception {
        TestSubscriber<Boolean> testSubscriber = new TestSubscriber<>();
        ZvonokMockRepository zvonokMockRepository = new ZvonokMockRepository();
        zvonokMockRepository.ring("some text").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Arrays.asList(false));
    }
}