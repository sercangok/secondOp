package com.salyangoz.org.secondop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salyangoz.org.secondop.R;
import com.salyangoz.org.secondop.fragment.customFragment.GoogleAnalyticsFragment;

/**
 * Created by sercangok on 31/01/15.
 */
public class Fragment1 extends GoogleAnalyticsFragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }
}
