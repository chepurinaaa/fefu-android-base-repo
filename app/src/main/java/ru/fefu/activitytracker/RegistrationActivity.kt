package ru.fefu.activitytracker

import android.os.Bundle
import android.view.View
import ru.fefu.activitytracker.R
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.fefu.activitytracker.databinding.ActivityRegistrationBinding

class RegistrationActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backLayout.setNavigationOnClickListener {
            onBackPressed()
        }
    }

}