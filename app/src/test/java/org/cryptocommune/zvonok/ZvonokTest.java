package org.cryptocommune.zvonok;

import android.support.v4.app.Fragment;
import android.view.View;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

/**
 * Created by Dema on 30.09.2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(application = TestZvonokApplication.class, constants = BuildConfig.class, sdk = 21)
public class ZvonokTest {

    private TestZvonokApplication app;

    @Before
    public void prepareTest() throws Exception {
        app = (TestZvonokApplication) RuntimeEnvironment.application;
    }

    @Test
    public void testCreateMainActivity() throws Exception {
        Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();
    }

    @Test
    public void testCreateZvonokFragment() throws Exception {
        Fragment fragment = ZvonokFragment.create();
        SupportFragmentTestUtil.startVisibleFragment(fragment);
        Assert.assertNotNull(fragment.getView());
    }

    @Test
    public void testZvonokButtonPress() throws Exception {
        ZvonokFragment zvonokFragment = (ZvonokFragment) ZvonokFragment.create();
        app.getApplicationComponent().inject(zvonokFragment);
        SupportFragmentTestUtil.startVisibleFragment(zvonokFragment);
        View ringButton = zvonokFragment.getView().findViewById(R.id.b_ring);
        Assert.assertTrue(ringButton.isEnabled());
        Assert.assertTrue(ringButton.performClick());
    }
}
