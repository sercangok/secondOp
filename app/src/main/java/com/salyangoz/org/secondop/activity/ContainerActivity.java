package com.salyangoz.org.secondop.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.salyangoz.org.secondop.R;
import com.salyangoz.org.secondop.activity.customActivity.GoogleAnlyticsActivity;
import com.salyangoz.org.secondop.fragment.Fragment1;
import com.salyangoz.org.secondop.fragment.Fragment2;
import com.salyangoz.org.secondop.fragment.Fragment3;
import com.salyangoz.org.secondop.fragment.Fragment4;

public class ContainerActivity extends GoogleAnlyticsActivity {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        init(savedInstanceState);

        //getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getActionBar().setCustomView(R.layout.bottombar);
    }

    private void init(Bundle savedInstanceState) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager
                .beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        fragmentTransaction.add(R.id.container, fragment1);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_container, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        fragmentTransaction = fragmentManager
                .beginTransaction();

        switch (id) {
            case R.id.fragment1:
                fragment1 = new Fragment1();
                fragmentTransaction.add(R.id.container, fragment1);
                break;
            case R.id.fragment2:
                fragment2 = new Fragment2();
                fragmentTransaction.add(R.id.container, fragment2);
                break;
            case R.id.fragment3:
                fragment3 = new Fragment3();
                fragmentTransaction = fragmentManager
                        .beginTransaction();
                fragmentTransaction.add(R.id.container, fragment3);
                break;
            case R.id.fragment4:
                fragment4 = new Fragment4();
                fragmentTransaction.add(R.id.container, fragment4);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        fragmentTransaction.commit();

        return super.onOptionsItemSelected(item);
    }
}
