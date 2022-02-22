package com.zeptolab.ctr.ui.progress_activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.zeptolab.ctr.databinding.ActivityProgressBinding
import com.zeptolab.ctr.ui.game_activity.PlayActivity

class LoadingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDelay()
    }

    private fun progressDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, PlayActivity::class.java))
        }, 2107)
    }
}