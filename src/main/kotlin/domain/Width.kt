package domain

import java.lang.NumberFormatException

class Width(private val rawWidth: String) {
    private val width: Int
    init {
        validate()
        width = rawWidth.toInt()
    }

    companion object {
        const val MINIMUM = 1
    }

    private fun validate() {
        val width: Int
        try {
            width = rawWidth.toInt()
        } catch(e: NumberFormatException) {
            throw Exception("숫자를 입력해주세요")
        }
        if (width < MINIMUM) {
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