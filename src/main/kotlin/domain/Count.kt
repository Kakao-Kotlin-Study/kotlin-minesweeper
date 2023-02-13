package domain

import java.lang.NumberFormatException

class Count(private val rawCount: String, getHeight: Height, getWidth: Width) {
    private val count: Int
    private val height: Height = getHeight
    private val width: Width = getWidth

    companion object {
        const val MINIMUM = 1
    }

    init {
        validate()
        count = rawCount.toInt()
    }

    private fun validate() {
        val count: Int
        try {
            count = rawCount.toInt()
        } catch(e: NumberFormatException) {
            throw Exception("숫자를 입력해주세요")
        }
        if (count < MINIMUM || count > height.multiple(width)) {
            throw Exception("개수는 항상 음수보다 크고 높이 X 너비 값보다 작거나 같습니다.")
        }
    }

    fun makeRandomCoordinates(): Coordinates {
        val list = MutableList(height.multiple(width)) { i -> Coordinate(width.getRowNum(i), width.getColNum(i)) }
        return Coordinates(list.shuffled().subList(0, count))
    }
}