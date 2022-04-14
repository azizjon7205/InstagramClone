package com.clone.instagramclone.manager.handler

import com.clone.instagramclone.model.User

interface DBUserHandler {
    fun onSuccess(user: User? = null)
    fun onError(e: Exception)
}