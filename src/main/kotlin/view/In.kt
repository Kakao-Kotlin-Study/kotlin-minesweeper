package view

import domain.Count
import domain.Height
import domain.Width
import java.util.*

object In {

    private val scanner: Scanner = Scanner(System.`in`)

    fun getHeight(): Height {
        val input = readln()
        return Height(input)
    }

    fun getWidth(): Width {
        val input = readln()
        return Width(input)
    }

    fun getCount(height: Height, width: Width): Count {
        val input = readln()
        return Count(input, height, width)
    }

}