package com.example.isrmensualarrendamiento

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class notificacion : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

            // Set the alarm here.
            var builder : NotificationCompat.Builder = NotificationCompat.Builder(context, "notifyLemubit")
                .setSmallIcon(R.drawable.ic_baseline_settings_24)
                .setContentTitle("Recordatorio")
                .setContentText("Realice sus calculos a tiempo")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            var notificationManager : NotificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManager.notify(200,builder.build())

    }
}