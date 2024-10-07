package com.example.myapplication_2.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.example.myapplication_2.R
import com.example.myapplication_2.databinding.ActivitySignupBinding
import com.example.myapplication_2.presentation.viewmodel.SignupViewModel

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val signupViewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        setTheme(R.style.Theme_MyApplication_2)

        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ユーザーがすでにログインしている場合、MainActivity に移動
        signupViewModel.checkUserLoggedIn()
        signupViewModel.signupResult.observe(this, Observer { isLoggedIn ->
            if (isLoggedIn) {
                moveToMainActivity()
            }
        })

        // 登録ボタンのクリックイベント
        binding.continueBtn.setOnClickListener {
            val username = binding.username.text.toString()
            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()

            // ViewModel に新規登録処理を依頼
            signupViewModel.signup(username, email, password)
        }

        // 新規ユーザー登録の結果を監視
        signupViewModel.signupResult.observe(this, Observer { isSuccess ->
            if (isSuccess) {
                moveToMainActivity()
            } else {
                Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        })

        // ログイン画面へ遷移
        binding.move.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moveToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}