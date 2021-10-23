package ru.fefu.activitytracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class RegistrationActivity: AppCompatActivity(R.layout.activity_registration) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registration)

        val backLayout = findViewById<MaterialButton>(R.id.invisibleButton)

        backLayout.setOnClickListener{
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}