package com.example.phonebroadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallBroadcast extends BroadcastReceiver {

    public static final String TAG = "llamadita";
    private static final int CALLNOTIFICATION = 1;

    @Override
    public void onReceive(Context context, Intent intent) {

        String state = "";
        String number = "";

        Log.d(TAG, "IntentRecogido");

        // Recoger datos del intent
        if (intent.getExtras() != null) {
            Bundle b = intent.getExtras();

            state = b.getString(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                // Recoger número de teléfono
                number = b.getString((TelephonyManager.EXTRA_INCOMING_NUMBER));

                // ¿A quién le pasamos la información?
                Intent otroIntent = new Intent(context, CallInformation.class);
                otroIntent.putExtra("numero", number);
                otroIntent.putExtra("idNotificacion", CALLNOTIFICATION);

                PendingIntent pendingIntent = PendingIntent.getActivity(context,CALLNOTIFICATION, otroIntent,0);
                // Crear la notificacion
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(context, "Notification");
                // Personalizando las opciones de notificación
                // Dos estados: notificacion aparecida y notificacion desplegada
                builder
                        .setContentTitle("PhoneBroadcast")
                        .setSmallIcon(android.R.drawable.sym_call_incoming)
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), android.R.drawable.sym_call_incoming))
                        .setContentText("Esto es una notificación de una llamada :)")
                        .setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(CALLNOTIFICATION, builder.build());

            }
        }
    }
}
