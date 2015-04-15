package com.anupcowkur.reservoir;

import android.test.suitebuilder.annotation.MediumTest;

import com.anupcowkur.reservoirsample.MainActivity;
import com.anupcowkur.reservoirsample.TestClass;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * The main reservoir class.
 */
public class ReservoirTest {

    MainActivity mainActivity;

    private static final String TEST_STRING = "my test string";
    private static final String KEY = "myKey";

    @Rule
    public final ActivityRule<MainActivity> rule = new ActivityRule<>(MainActivity.class);

    @Before
    public void init() {
        mainActivity = rule.get();
    }

    @Test
    @MediumTest
    public void testShouldPutAndGetObjectOnMainThread() throws Exception {

        TestClass testPutObject = new TestClass();

        testPutObject.setTestString(TEST_STRING);

        Reservoir.put(KEY, testPutObject);

        TestClass testResultObject = Reservoir.get(KEY, TestClass.class);

        assertEquals(TEST_STRING, testResultObject.getTestString());

    }

}
