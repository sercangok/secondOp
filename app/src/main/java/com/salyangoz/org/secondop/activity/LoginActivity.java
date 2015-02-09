package com.salyangoz.org.secondop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;
import com.salyangoz.org.secondop.R;
import com.salyangoz.org.secondop.activity.customActivity.GoogleAnlyticsActivity;


public class LoginActivity extends GoogleAnlyticsActivity {

    private UiLifecycleHelper uiHelper;
    private LoginButton fbLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("info", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        facebookConfig(savedInstanceState);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, GoogleActivity.class));
            }
        });
    }

    private void facebookConfig(Bundle savedInstanceState) {
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
        fbLoginButton = (LoginButton) findViewById(R.id.authButton);
        //fbLoginButton.setFragment(this);
    }

    @Override
    public void onResume() {
        Log.i("info", "onResume");
        super.onResume();
        Session session = Session.getActiveSession();
        if (session != null &&
                (session.isOpened() || session.isClosed())) {
            onSessionStateChange(session, session.getState(), null);
        }
        uiHelper.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("info", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        //FaceBook
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        Log.i("info", "onPause");
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        Log.i("info", "onDestroy");
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("info", "onSavedInstanceState");
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState sessionState, Exception exception) {
            Log.i("info", "StatusCallBacl.Call");
            onSessionStateChange(session, sessionState, exception);
        }
    };

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        Log.i("info", "onSessionStateChange");
        if (state.isOpened()) {
            Log.i("log", "FaceBook Logged in...");
        } else if (state.isClosed()) {
            Log.i("log", "FaceBook Logged out...");
        }
    }

    public void onClickLogin(View v) {
        startActivity(new Intent(this, ContainerActivity.class));
    }
}
