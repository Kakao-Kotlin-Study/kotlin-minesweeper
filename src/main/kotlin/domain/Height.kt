package domain

import java.lang.NumberFormatException
    private val height: Int

    init {
        validate()
        height = rawHeight
    }

    companion object {
        const val MINIMUM = 1
    }

    private fun validate() {
        if (rawHeight < Companion.MINIMUM) {
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