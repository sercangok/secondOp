package com.salyangoz.org.secondop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salyangoz.org.secondop.R;
import com.salyangoz.org.secondop.fragment.customFragment.Fragment5;
import com.salyangoz.org.secondop.fragment.customFragment.GoogleAnalyticsFragment;

/**
 * Created by sercangok on 01/02/15.
 */
public class Fragment2 extends GoogleAnalyticsFragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);
        init();
        return view;
    }

    private void init() {
        view.findViewById(R.id.btnTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.container, new Fragment5()).addToBackStack(null).commit();
            }
        });
    }
}
