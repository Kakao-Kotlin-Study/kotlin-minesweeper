package view

import domain.Count
import domain.Height
import domain.Width
import java.util.*

object In {

    private val scanner: Scanner = Scanner(System.`in`)

    fun getHeight(): Height {
        val input = scanner.nextInt()
        return Height(input)
    }

    fun getWidth(): Width {
        val input = scanner.nextInt()
        return Width(input)
    }

    fun getCount(height: Height, width: Width): Count {
        val input = scanner.nextInt()
        return Count(input, height, width)
    }

}