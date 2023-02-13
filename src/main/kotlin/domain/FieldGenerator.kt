package domain

class FieldGenerator(private val height: Height, private val width: Width, private val mineCount: MineCount) {

    fun generate(): Field {
        val safeField = height.makeSafeField(width)
        val coords: Coordinates = mineCount.makeRandomCoordinates()
        return coords.layMines(safeField)
    }

}