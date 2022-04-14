package com.clone.instagramclone.manager.handler

import com.clone.instagramclone.model.User
import java.lang.Exception

interface DBUsersHandler {
    fun onSuccess(users: ArrayList<User>)
    fun onError(e: Exception)
}