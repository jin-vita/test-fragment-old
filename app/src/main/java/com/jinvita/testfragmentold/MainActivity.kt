package com.jinvita.testfragmentold

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(this, MainFragment(), false)
    }

    fun replaceFragment(activity: MainActivity, fragment: Fragment, back: Boolean = true) {
        activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            if (back) addToBackStack(null)
        }.commit()
    }
}