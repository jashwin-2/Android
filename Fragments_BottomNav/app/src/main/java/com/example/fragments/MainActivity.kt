package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = FragmentHome()
        val settingsFragment = FragmentSettings()
        val messageFragment = FragmentMessage()
        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miMessage -> setCurrentFragment(messageFragment)
                R.id.miSettings -> setCurrentFragment(settingsFragment)
            }
            true
        }

    }
    private fun setCurrentFragment(fragment: Fragment)=  supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
       // addToBackStack(null)
        commit()
    }
}