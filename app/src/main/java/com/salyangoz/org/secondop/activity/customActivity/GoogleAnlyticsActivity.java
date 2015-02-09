package com.salyangoz.org.secondop.activity.customActivity;

import android.app.Activity;

import com.google.android.gms.analytics.GoogleAnalytics;

/**
 * Created by sercangok on 30/01/15.
 */
public class GoogleAnlyticsActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }
}
