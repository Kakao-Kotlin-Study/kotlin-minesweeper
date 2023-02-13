package view

import domain.MineCount
import domain.Height
import domain.Width

object In {

    fun getHeight(): Height {
        val input = readln()
        return Height(input)
    }

    fun getWidth(): Width {
        val input = readln()
        return Width(input)
    }

    fun getCount(height: Height, width: Width): MineCount {
        val input = readln()
        return MineCount(input, height, width)
    }

}