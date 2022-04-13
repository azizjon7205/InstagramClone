package com.clone.instagramclone.utils

import android.app.Application
import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import com.clone.instagramclone.model.ScreenSize

object Utils {

    fun toast(context: Context, msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun screenSize(context: Application): ScreenSize{
        val displayMetrics = DisplayMetrics()
        val windowsmanager = context.getSystemService(WINDOW_SERVICE) as WindowManager
        windowsmanager.defaultDisplay.getMetrics(displayMetrics)
        val deviceWidth = displayMetrics.widthPixels
        val deviceHeight = displayMetrics.heightPixels
        return ScreenSize(deviceWidth, deviceHeight)
    }
}