package rx.plugins;

/**
 * Created by Dema on 30.09.2016.
 */

public class RxJavaTestPlugins extends RxJavaPlugins {
    RxJavaTestPlugins() {
        super();
    }

    public static void resetPlugins(){
        getInstance().reset();
    }
}

