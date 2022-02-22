package com.zeptolab.ctr.ui.game_activity

import com.zeptolab.ctr.R
import kotlin.random.Random

class Generator {

    fun generate(): ArrayList<FortuneItem> {
        var index = 16
        val list = ArrayList<FortuneItem>()

        while (index > 0) {
            list.add(FortuneItem(generateResource()))

            index--
        }

        return list
    }

    private fun generateResource(): Int {
        var resource = 0

        when (Random.nextInt(5) + 1) {
            1 -> resource = R.drawable.fortune1
            2 -> resource = R.drawable.fortune2
            3 -> resource = R.drawable.fortune3
            4 -> resource = R.drawable.fortune4
            5 -> resource = R.drawable.fortune5
        }

        return resource
    }
}