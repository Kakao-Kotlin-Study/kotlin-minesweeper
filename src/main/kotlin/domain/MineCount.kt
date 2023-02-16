package domain

class MineCount(private val count: String, private val rowNum: RowNum, private val colNum: ColNum) {
    private val mineCount: Int

    companion object {
        const val MINIMUM = 1
    }

    init {
        validate()
        mineCount = count.toInt()
    }

    private fun validate() {
        val countNum: Int
        try {
            countNum = count.toInt()
        } catch(e: NumberFormatException) {
            throw Exception("숫자를 입력해주세요")
        }
        if (countNum < MINIMUM || countNum > rowNum.multiple(colNum)) {
            throw Exception("개수는 항상 음수보다 크고 높이 X 너비 값보다 작거나 같습니다.")
        }
    }

    fun makeRandomCoordinates(): Coordinates {
        val list = MutableList(rowNum.multiple(colNum)) { i -> Coordinate(colNum.getRowNum(i), colNum.getColNum(i)) }
        return Coordinates(list.shuffled().subList(0, mineCount))
    }
}