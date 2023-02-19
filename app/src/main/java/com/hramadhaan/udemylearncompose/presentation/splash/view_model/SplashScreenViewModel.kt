package com.hramadhaan.udemylearncompose.presentation.splash.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashScreenViewModel() : ViewModel() {
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val auth: FirebaseAuth = Firebase.auth

    fun currentAuthStatus(onResult: (Boolean) -> Unit) {
        val isLogin: Boolean = !FirebaseAuth.getInstance().currentUser?.email.isNullOrBlank()
        onResult(isLogin)
    }
}