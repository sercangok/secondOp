package com.salyangoz.org.secondop.fragment.customFragment;


import android.app.Fragment;
import android.support.annotation.Nullable;

import com.google.android.gms.analytics.GoogleAnalytics;

/**
 * Created by sercangok on 31/01/15.
 */
public class GoogleAnalyticsFragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(getActivity().getApplicationContext()).reportActivityStart(getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(getActivity().getApplicationContext()).reportActivityStop(getActivity());
    }
}
