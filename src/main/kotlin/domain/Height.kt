package domain

import java.lang.NumberFormatException

class Height(private val rawHeight: String) {
    private val height: Int

    init {
        validate()
        height = rawHeight.toInt()
    }

    companion object {
        const val MINIMUM = 1
    }

    private fun validate() {
        val height: Int
        try {
            height = rawHeight.toInt()
        } catch(e: NumberFormatException) {
            throw Exception("숫자를 입력해주세요")
        }
        if (height < MINIMUM) {
            throw Exception("높이는 항상 양수입니다")
        }
    }

    fun multiple(width: Width): Int {
        return width.multiple(height)
    }

    fun makeSafeField(width: Width): Field {
        return Field(MutableList(height) { width.makeSafeRow() })
    }
}