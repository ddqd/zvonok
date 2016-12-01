package rx.plugins;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Dema on 30.09.2016.
 */
public class RxJavaTestRunner extends RobolectricTestRunner {
    public RxJavaTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);

        RxJavaTestPlugins.resetPlugins();
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        });
    }
}