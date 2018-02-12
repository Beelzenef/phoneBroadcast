package com.example.phonebroadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CallInformation extends AppCompatActivity {

    private TextView txtV_Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_information);

        txtV_Number = (TextView) findViewById(R.id.txtV_Numero);
        txtV_Number.setText(getIntent().getStringExtra("numero"));
    }

}
