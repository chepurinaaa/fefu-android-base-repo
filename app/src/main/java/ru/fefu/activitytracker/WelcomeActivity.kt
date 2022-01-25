package ru.fefu.activitytracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import ru.fefu.activitytracker.R
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import ru.fefu.activitytracker.databinding.ActivityWelcomeBinding

class WelcomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registrationView.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        binding.haveAnAccountView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}