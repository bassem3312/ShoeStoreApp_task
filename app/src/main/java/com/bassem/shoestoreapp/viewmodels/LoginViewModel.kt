package com.bassem.shoestoreapp.viewmodels

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bassem.shoestoreapp.models.User
import com.bassem.shoestoreapp.utils.SingleLiveEvent

class LoginViewModel() : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _isLoginSuccess = SingleLiveEvent<Boolean>()
    fun getIsLoginSuccess(): SingleLiveEvent<Boolean> {
        return _isLoginSuccess
    }

    init {
        _user.value = User("basem@gmail.com", "Passworddddddddd")
    }

    //create function to process Login Button clicked
    fun onLoginClicked(v: View) {
//        Log.e("====Selected Email", _user.value!!.password)
//        Log.e("====Selected Password", _user.value!!.password)

        _isLoginSuccess.value = !(user.value!!.userEmail.isEmpty() || user.value!!.password.isEmpty())


    }


}