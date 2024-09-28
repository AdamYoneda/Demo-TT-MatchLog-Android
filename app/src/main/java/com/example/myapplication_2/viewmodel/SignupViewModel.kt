package com.example.myapplication_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore

    // 新規ユーザー登録結果を管理する LiveData
    private val _signupResult = MutableLiveData<Boolean>()
    val signupResult: LiveData<Boolean> = _signupResult

    // 新規ユーザー登録
    fun signup(userName: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    userId?.let {
                        val user = hashMapOf(
                            "user_id" to it,
                            "user_name" to userName,
                            "email" to email,
                            "joined_date" to Timestamp.now()
                        )
                        // Firestoreのusersコレクションにユーザーデータを保存
                        db.collection("users").document(it).set(user)
                            .addOnSuccessListener {
                                // Firestoreへの保存成功
                                _signupResult.value = true
                            }
                            .addOnFailureListener {
                                // Firestoreへの保存失敗
                                _signupResult.value = false
                            }
                    } ?: run {
                        // Firestoreへの保存失敗
                        _signupResult.value = false
                    }
                } else {
                    // Authでのユーザー登録の失敗
                    _signupResult.value = false
                }
            }
    }

    // 現在のユーザーのチェック
    fun isUserLoggedIn(): Boolean {
        return  auth.currentUser != null
    }
}