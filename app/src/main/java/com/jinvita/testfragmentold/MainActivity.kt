package com.jinvita.testfragmentold

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), FragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(this, MainFragment(), back = false)
    }

    override fun replaceFragment(activity: Activity, fragment: Fragment, back: Boolean) {
        (activity as MainActivity).supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            if (back) addToBackStack(null)
        }.commit()
    }
}