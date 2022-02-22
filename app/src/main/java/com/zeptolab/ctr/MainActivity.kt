package com.zeptolab.ctr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zeptolab.ctr.databinding.ActivityMainBinding
import com.zeptolab.ctr.ui.progress_activity.LoadingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuBtn1.setOnClickListener {
            finish()
        }

        binding.menuBtn2.setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }
    }
}