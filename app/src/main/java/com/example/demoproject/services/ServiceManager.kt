package com.example.demoproject.services

import android.content.Context
import android.content.Intent

class ServiceManager(private val context: Context) {
    private val serviceIntent = Intent(context, NotificationService::class.java)
    fun startNotificationService() {
        serviceIntent.also {
            it.action = NotificationService.Actions.START.toString()
            context.startService(it)
        }
    }

    fun stopNotificationService(id: Int) {
        serviceIntent.also {
            it.action = NotificationService.Actions.STOP.toString()
            context.startService(it)
        }
    }

}