package com.example.phonebroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendIntent(View v) {
        Intent intent = new Intent("com.example.phonebroadcast.intent");
        Bundle b = new Bundle();
        b.putString(TelephonyManager.EXTRA_STATE, "RINGING");
        b.putString(TelephonyManager.EXTRA_INCOMING_NUMBER, "658915414");
        intent.putExtras(b);
        sendBroadcast(intent);
    }
}
