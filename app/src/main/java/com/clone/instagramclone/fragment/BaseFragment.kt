package com.clone.instagramclone.fragment

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import com.clone.instagramclone.activity.SignInActivity

/**
 * BaseFragment for all fragments
 */

open class BaseFragment: Fragment() {

    fun callSignInActivity(activity: Activity){
        val intent = Intent(context, SignInActivity::class.java)
        startActivity(intent)
        activity.finish()
    }
}