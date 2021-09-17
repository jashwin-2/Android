package com.example.services

import android.content.Intent
import android.media.MediaPlayer
import android.media.audiofx.BassBoost
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}