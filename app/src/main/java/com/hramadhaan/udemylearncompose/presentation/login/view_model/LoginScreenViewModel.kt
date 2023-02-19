package com.hramadhaan.udemylearncompose.presentation.login.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel() : ViewModel() {
    //    val loadingState = MutableStateFlow(LoadingState.LOADING)
    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onError: (String) -> Unit,
        onSuccess: () -> Unit
    ) = viewModelScope.launch {
        try {
            _loading.value = true
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener { user ->
                Log.d("SignInEmailSuccess", user.toString())
                _loading.value = false
                onSuccess()
            }.addOnFailureListener {
                _loading.value = false
                onError(it.message.toString())
                Log.e("SignInEmailFailure", it.message.toString())
            }
        } catch (err: Exception) {
            _loading.value = false
            Log.e("SignInEmailCatch", err.message.toString())
        }
    }
}