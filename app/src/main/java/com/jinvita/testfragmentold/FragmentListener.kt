package com.jinvita.testfragmentold

import android.app.Activity
import androidx.fragment.app.Fragment

interface FragmentListener {
    fun replaceFragment(activity: Activity, fragment: Fragment, back: Boolean = true)
}