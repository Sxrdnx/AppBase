package com.example.mospertestsapprefactor.presentation.login

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mospertestsapprefactor.utils.Constanst
import com.example.mospertestsapprefactor.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val MAX_LENGTH_PASSWORD = 5

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var shaPref : SharedPreferences

    private val _loginState= MutableLiveData<Resource<String>>()
    val loginState: LiveData<Resource<String>> get() =  _loginState


    fun login(email: String, password:String){
        if (email.isEmpty() || password.isEmpty()){
            _loginState.value = Resource.error("LLene todos los campos",null)
            return
        }

        if (password.length < MAX_LENGTH_PASSWORD){
            _loginState.value = Resource.error("La contraseña debe ser de minimo $MAX_LENGTH_PASSWORD",null)
            return
        }

        shaPref.edit().putString(Constanst.KEY_LOGGED_IN_EMAIL,email).apply()
        shaPref.edit().putString(Constanst.KEY_PASSWORD,password).apply()
        _loginState.value = Resource.success("loggin!")
    }

}