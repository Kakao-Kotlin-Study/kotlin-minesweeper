package domain

class Spec(private val height: Height, private val width: Width, private val count: Count) {

    fun makeField(): Field {
        val safeField = height.makeSafeField(width)
        val coords: Coordinates = count.makeRandomCoordinates()
        return coords.layMines(safeField)
    }

}