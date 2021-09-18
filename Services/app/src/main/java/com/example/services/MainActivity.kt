package com.example.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.media.MediaPlayer
import android.media.audiofx.BassBoost
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
            Intent(this, MyAndroidService::class.java).also {
                startService(it)
            }
        }

        btnStop.setOnClickListener {
            Intent(this, MyAndroidService::class.java).also {
                stopService(it)
            }

        }

        btnGetTime.setOnClickListener{
            val time = myService.getTime()
            tvTime.text = time
        }
    }

    //Bonded Service
    private lateinit var myService: MyAndroidService
    private var bound = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service : IBinder?) {
            val binder = service as MyAndroidService.LocalBinder
            myService = binder.getService()
            bound=true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            bound= false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this,MyAndroidService::class.java).also {
            bindService(it,connection,Context.BIND_AUTO_CREATE)
        }
    }
}