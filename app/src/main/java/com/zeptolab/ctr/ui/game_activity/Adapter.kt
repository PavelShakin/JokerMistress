package com.zeptolab.ctr.ui.game_activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zeptolab.ctr.R
import com.zeptolab.ctr.databinding.ItemFortuneBinding

interface AdapterCallback {
    fun fortuneClick(bonus: Int)
    fun triesLeft(tries: Int)
    fun noMoreTries(text: String)
}

class Adapter(val listener: AdapterCallback) :
    RecyclerView.Adapter<Adapter.EntityViewHolder>() {

    private var tries = 5
    private var total = 0

    var fortuneList: MutableList<FortuneItem> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val binding = ItemFortuneBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return EntityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.EntityViewHolder, position: Int) {
        fortuneList[position].let { holder.binding(it) }
    }

    override fun getItemCount(): Int = fortuneList.size

    inner class EntityViewHolder(private val binding: ItemFortuneBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binding(item: FortuneItem) {
            binding.fortuneImg.setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
            binding.fortuneImg.setBackgroundColor(Color.GRAY)

            binding.fortuneImg.setOnClickListener {
                if (tries > 0) {
                    if (item.resource == R.drawable.fortune1 ||
                        item.resource == R.drawable.fortune2
                    ) {
                        total += 0

                        binding.fortuneImg.setImageResource(item.resource)
                        binding.fortuneImg.setBackgroundColor(Color.WHITE)
                    } else if (item.resource == R.drawable.fortune3 ||
                        item.resource == R.drawable.fortune4
                    ) {
                        total += 50

                        binding.fortuneImg.setImageResource(item.resource)
                        binding.fortuneImg.setBackgroundColor(Color.GREEN)
                    } else {
                        total += 100

                        binding.fortuneImg.setImageResource(item.resource)
                        binding.fortuneImg.setBackgroundColor(Color.YELLOW)
                    }

                    tries--
                    listener.triesLeft(tries)
                } else {
                    listener.fortuneClick(total)
                    listener.noMoreTries("You spend all tries, try again!")
                }
            }
        }
    }
}