package domain

object FieldGenerator {

    fun generate(rowNum: RowNum, colNum: ColNum, mineCount: MineCount): Field {
        val safeField = rowNum.makeSafeField(colNum)
        val coords: Coordinates = mineCount.makeRandomCoordinates()
        return coords.layMines(safeField)
    }

}