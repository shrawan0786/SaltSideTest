package com.test.saltside.tests;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import android.widget.TextView;

import com.test.saltside.LandingScreen;
import com.test.saltside.MainScreen;
import com.test.saltside.R;

public class MainScreenTest extends
		ActivityInstrumentationTestCase2<MainScreen> {

	private LandingScreen mLandingScreen;
	private MainScreen mMainActivity;
	private ListView mListview;
	private TextView mTitleTV;

	public MainScreenTest(Class<MainScreen> activityClass) {
		super(activityClass);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mMainActivity = (MainScreen) getActivity();
		mListview = (ListView) mMainActivity.findViewById(R.id.listv);
	}

	public void testCase1() {
		assertNotNull(mMainActivity);
		assertNotNull(mListview);
	}

	public void testCase2() {

		Instrumentation instrumentation = getInstrumentation();
		Instrumentation.ActivityMonitor monitor = instrumentation.addMonitor(
				LandingScreen.class.getName(), null, false);

		mMainActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {

				mListview.performItemClick(mListview, 4, 0);
				// mListview is listview, 4 is item position,0 is default id
			}
		});

		Activity currentActivity = getInstrumentation().waitForMonitor(monitor);
		mLandingScreen = (LandingScreen) currentActivity;

		assertNotNull(mLandingScreen);
		mTitleTV = (TextView) mLandingScreen.findViewById(R.id.title);

		assertNotNull(mTitleTV);
		assertEquals("Karan", mTitleTV.getText().toString());

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();

		mMainActivity = null;
		mListview = null;
		mTitleTV = null;
		mLandingScreen = null;

	}
}
