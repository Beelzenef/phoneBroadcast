package com.example.phonebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CallBroadcast extends BroadcastReceiver {

    public static final String TAG = "llamadita";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "IntentRecogido");
    }
}
