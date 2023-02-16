package domain

class ColNum(private val width: String) {
    private val colNum: Int
    init {
        validate()
        colNum = width.toInt()
    }

    companion object {
        const val MINIMUM = 1
    }

    private fun validate() {
        val widthNum: Int
        try {
            widthNum = width.toInt()
        } catch(e: NumberFormatException) {
            throw Exception("숫자를 입력해주세요")
        }
        if (widthNum < MINIMUM) {
            throw Exception("너비는 항상 양수입니다")
        }
    }

    fun multiple(height: Int): Int {
        return colNum * height
    }

    fun getRowNum(idx: Int): Int {
        return idx / colNum
    }

    fun getColNum(idx: Int): Int {
        return idx % colNum
    }

    fun makeSafeRow(): MutableList<Section> {
        return MutableList(colNum) { Safe() }
    }
}