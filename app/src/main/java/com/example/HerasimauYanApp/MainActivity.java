package com.example.HerasimauYanApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;


import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    private static final String APP_CENTER_KEY = "4c4d6d0f-6897-4a64-b6de-5755b2b43a27";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());   //, //new CrashlyticsNdk());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppCenter.start(getApplication(), "APP_CENTER_KEY",
                Analytics.class, Crashes.class);
        AppCenter.start(getApplication(), APP_CENTER_KEY, Distribute.class);

        final TextView version = findViewById(R.id.version);
        version.setText(BuildConfig.VERSION_NAME);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
