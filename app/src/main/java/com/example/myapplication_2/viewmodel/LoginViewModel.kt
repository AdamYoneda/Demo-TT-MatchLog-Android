package com.example.myapplication_2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication_2.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore

    // ログイン結果を管理する LiveData
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    // ログイン処理
    fun login(email: String, password: String) {
        // 1. Authでの既存のユーザーのログイン
        authLogin(email,password) { userId ->
            if (userId != null) {
                // 2. ユーザー情報取得
                fetchUserInfo(userId) { fetchResult ->
                    _loginResult.value = fetchResult
                }
            } else {
                _loginResult.value = false // Auth失敗
            }
        }
    }

    private fun authLogin(email: String, password: String, onResult: (String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    onResult(userId)
                } else {
                    onResult(null)
                }
            }
    }

    private fun fetchUserInfo(userId: String, onResult: (Boolean) -> Unit) {
        db.collection("users").document(userId).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    // Firestoreから取得したデータをUserモデルに変換
                    val user = User(
                        userId = document.getString("user_id") ?: "",
                        userName = document.getString("user_name") ?: "",
                        email = document.getString("email") ?: "",
                        joinedDate = document.getTimestamp("joined_date")
                    )

                    // 成功としてコールバック
                    onResult(true)
                } else {
                    // 取得に失敗した場合
                    Log.d("Firestore", "Failed to fetch user data")
                    onResult(false)
                }
            }
            .addOnFailureListener {
                onResult(false)
            }
    }

    // 現在のユーザーのチェック
    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}