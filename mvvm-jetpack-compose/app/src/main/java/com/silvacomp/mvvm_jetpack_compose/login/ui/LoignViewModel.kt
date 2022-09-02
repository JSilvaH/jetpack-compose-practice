package com.silvacomp.mvvm_jetpack_compose.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel(){



    private val _email = MutableLiveData<String>()
    val email: LiveData<String> =_email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> =_password
    
    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> =_loginEnabled
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> =_isLoading
    
    

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = isEmailValid(email) && isPasswordValid(password)
    }

    private fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String): Boolean = password.length > 6

    suspend fun onLoginSelected(){
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

}
