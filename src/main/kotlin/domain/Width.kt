package domain

import java.lang.NumberFormatException
    private val width: Int
    init {
        validate()
        width = rawWidth
    }

    companion object {
        const val MINIMUM = 1
    }

    private fun validate() {
        if (rawWidth < Companion.MINIMUM) {
            throw Exception("너비는 항상 양수입니다")
        }
    }

    fun multiple(height: Int): Int {
        return width * height
    }

    fun getRowNum(idx: Int): Int {
        return idx / width
    }

    fun getColNum(idx: Int): Int {
        return idx % width
    }

    fun makeSafeRow(): Row {
        return Row(MutableList(width) { Safe() })
    }
}