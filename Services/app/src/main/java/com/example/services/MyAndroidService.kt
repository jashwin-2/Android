package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.*
import android.provider.Settings
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class MyAndroidService : Service() {
    private lateinit var player : MediaPlayer
    private lateinit var handler : Handler
    private lateinit var serviceLooper: Looper
    public var id : Int = 0

    override fun onCreate() {
        super.onCreate()
        HandlerThread("MyAndroidThread").apply {
            start()
            serviceLooper = looper
            handler = object : Handler(looper){
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    player = MediaPlayer.create(msg.obj as MyAndroidService, Settings.System.DEFAULT_ALARM_ALERT_URI)
                    player.isLooping = true
                    player.start()
                    try{
                        Thread.sleep(3000)
                    }
                    catch (ex : InterruptedException){

                    }
                   // stopSelf(msg.arg1)
                    player.stop()
                }
            }
        }
    }

    //Started Service

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Service Without Handler and Thread

//        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
//        player.isLooping = true
//        player.start()

        //With Handler
        var message = Message()
        this.id=startId
        message.obj = this
        message.arg1=startId
        handler.sendMessage(message)
        return START_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    //Bounded Service
    private val binder = LocalBinder()

    inner class LocalBinder() : Binder(){
        fun getService() = this@MyAndroidService
    }

    override fun onBind(intent : Intent?): IBinder? {
        return binder
    }

    fun getTime(): String {
        val time = SimpleDateFormat("ss.mm.hh   dd/mm/yy" , Locale.US)
        return time.format(Date())
    }

}