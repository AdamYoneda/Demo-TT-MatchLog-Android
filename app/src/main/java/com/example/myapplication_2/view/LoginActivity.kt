package com.example.myapplication_2.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.example.myapplication_2.databinding.ActivityLoginBinding
import com.example.myapplication_2.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // ユーザーがすでにログインしている場合、MainActivity に移動
        if (loginViewModel.isUserLoggedIn()) {
            moveToMainActivity()
        }

        // ログインボタンのクリックイベント
        binding.continueBtn.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            // ViewModel にログイン処理を依頼
            loginViewModel.login(email, password)
        }

        // ログイン結果を監視
        loginViewModel.loginResult.observe(this, Observer { isSuccess ->
            if (isSuccess) {
                moveToMainActivity()
            } else {
                Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        })

        // 登録画面へ遷移
        binding.move.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moveToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}