package com.example.meet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!AppCenter.isConfigured()){
            AppCenter.start(getApplication(), "464aa4d5-2543-4882-9696-0c3e51e15911", Analytics.class, Crashes.class);
        }

    }

    public void clicked(View view) {
        Crashes.generateTestCrash();
    }
}
