package com.kiran.notificationandwearos

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        btn1.setOnClickListener {
            loadNotification1()
        }

        btn2.setOnClickListener {
            loadNotification2()
        }
    }

    fun loadNotification1() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannel(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("High priority notification")
            .setContentText("This is my notification body")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(1, notification)
    }

    fun loadNotification2() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannel(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_2)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("Low priority notification")
            .setContentText("This is my notification body")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(2, notification)
    }
}


