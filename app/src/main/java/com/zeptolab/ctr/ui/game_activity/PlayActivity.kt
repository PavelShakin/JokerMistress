package com.zeptolab.ctr.ui.game_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.zeptolab.ctr.MainActivity
import com.zeptolab.ctr.databinding.ActivityGameBinding

class PlayActivity : AppCompatActivity(), AdapterCallback {

    private var bonus = 0
    private val fortuneAdapter = Adapter(this as AdapterCallback)
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        backButtonPressed()
        fortuneAdapter.fortuneList = Generator().generate()
    }

    private fun initRecycler() {
        binding.gameRecycler.apply {
            layoutManager = GridLayoutManager(context, 4)
            adapter = fortuneAdapter
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun backButtonPressed() {
        binding.gameBtn1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun fortuneClick(bonus: Int) {
        this.bonus += bonus
        Toast.makeText(applicationContext, "Your win is $bonus!!!", Toast.LENGTH_SHORT).show()
    }

    override fun triesLeft(tries: Int) {
        binding.gameTxt.text = "$tries tries left"
    }

    override fun noMoreTries(text: String) {
        Toast.makeText(applicationContext, "$text", Toast.LENGTH_SHORT).show()

        binding.gameBtn2.visibility = View.VISIBLE
        binding.gameBtn2.setOnClickListener {
            startActivity(Intent(this, PlayActivity::class.java))
        }
    }
}