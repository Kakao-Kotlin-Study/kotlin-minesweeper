package domain

class RowNum(private val height: String) {
    private val rowNum: Int

    init {
        validate()
        rowNum = height.toInt()
    }

    companion object {
        const val MINIMUM = 1
    }

    private fun validate() {
        val heightNum: Int
        try {
            heightNum = height.toInt()
        } catch(e: NumberFormatException) {
            throw Exception("숫자를 입력해주세요")
        }
        if (heightNum < MINIMUM) {
            throw Exception("높이는 항상 양수입니다")
        }
    }

    fun multiple(colNum: ColNum): Int {
        return colNum.multiple(rowNum)
    }

    fun makeSafeField(colNum: ColNum): Field {
        return Field(MutableList(rowNum) { colNum.makeSafeRow() })
    }
}