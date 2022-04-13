package com.clone.instagramclone.manager

import com.clone.instagramclone.manager.handler.AuthHandler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthManager {
    companion object{
        val firebaseauth: FirebaseAuth = FirebaseAuth.getInstance()

        fun isSignedIn(): Boolean{
            return currentUser() != null
        }

        fun currentUser(): FirebaseUser?{
            return firebaseauth.currentUser
        }

        fun signIn(email: String, password: String, handler: AuthHandler){
            firebaseauth.signInWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    val uid = currentUser()!!.uid
                    handler.onSuccess(uid)
                } else{
                    handler.onError(task.exception)
                }
            }
        }

        fun signUp(email: String, password: String, handler: AuthHandler){
            firebaseauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    val uid = currentUser()!!.uid
                    handler.onSuccess(uid)
                } else{
                    handler.onError(task.exception)
                }
            }
        }

        fun signOut(){
            firebaseauth.signOut()
        }
    }
}