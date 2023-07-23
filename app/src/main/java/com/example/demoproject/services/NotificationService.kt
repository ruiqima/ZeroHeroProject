package com.example.demoproject.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.demoproject.R

class NotificationService() : Service() {
    private lateinit var notificationManager: NotificationManagerCompat
    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManagerCompat.from(this)
        createNotificationChannel()
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stop(
            )
        }

        val rtnValue = super.onStartCommand(intent, flags, startId)

        if (intent == null) {
            return rtnValue
        }

        return START_STICKY
    }

    private fun start() {

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle(
                "Next time let's do some Nature Noshing"
            ).setContentText("These are the suggested activities for you!").build()

        try {
            notificationManager.notify(1, notification)
        } catch (e: SecurityException) {
            onErrorPermissionNotGranted(e)
        }
    }

    private fun stop() {
        stopSelf()
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, NOTIFICATION_NAME, NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun onErrorPermissionNotGranted(e: SecurityException) {
    }

    override fun onDestroy() {
        super.onDestroy()
        stopForeground(STOP_FOREGROUND_REMOVE)
    }

    enum class Actions {
        START, STOP
    }

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID"
        const val NOTIFICATION_NAME = "Suggestions Notifications"
    }
}
