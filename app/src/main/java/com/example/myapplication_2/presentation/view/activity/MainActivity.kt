package com.example.myapplication_2.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_2.databinding.ActivityMainBinding
import com.example.myapplication_2.utils.UserManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch user information from UserManager and display it
        displayUserInfo()

        binding.logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            UserManager.clearUser()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.moveBtn.setOnClickListener {
            val intent = Intent(this, MatchRecordActivity::class.java)
            startActivity(intent)
        }
    }

    // Method to display user info
    private fun displayUserInfo() {
        val user = UserManager.getUser()

        if (user != null) {
            binding.userNameText.text = "User Name: ${user.userName}"
            binding.emailText.text = "Email: ${user.email}"
            binding.joinedDateText.text = "Joined Date: ${user.joinedDate?.toDate()?.toString() ?: "N/A"}"
        } else {
            binding.userNameText.text = "User not found"
            binding.emailText.text = ""
            binding.joinedDateText.text = ""
        }
    }
}