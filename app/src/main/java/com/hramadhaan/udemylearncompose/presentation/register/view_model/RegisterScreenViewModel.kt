package com.hramadhaan.udemylearncompose.presentation.register.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.hramadhaan.udemylearncompose.domain.model.User
import kotlinx.coroutines.launch

class RegisterScreenViewModel() : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private fun insertUser(displayName: String?) {
        val userId = auth.currentUser?.uid
//        val user = mutableMapOf<String, Any>()
//        user["user_id"] = userId.toString()
//        user["display_name"] = displayName.toString()
        val user = User(
            userId = userId.toString(),
            fullName = displayName.toString(),
            avatarUrl = "",
            quote = "Great",
            profession = "Android Developer",
            id = null
        ).toMap()
        FirebaseFirestore.getInstance().collection("users").add(user)
    }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        fullName: String,
        onError: (String) -> Unit,
        onSuccess: () -> Unit
    ) =
        viewModelScope.launch {
            try {
                _loading.value = true
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener { data ->
                        insertUser(fullName)
                        _loading.value = false
                        onSuccess()
                        Log.d("OnSuccess", data.toString())
                    }.addOnFailureListener { error ->
                        _loading.value = false
                        onError(error.message.toString())
                    }
            } catch (err: Exception) {
                _loading.value = false
                Log.e("CreateUserEmailCatch", err.message.toString())
            }
        }

}