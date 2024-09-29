package com.example.myapplication_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication_2.model.User

class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    // ユーザー情報をセットする関数
    fun setUser(userData: User) {
        _user.value = userData
    }

    // ユーザー情報を取得する関数
    fun getUser(): User? {
        return _user.value
    }
}