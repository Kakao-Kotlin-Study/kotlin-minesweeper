package domain

data class Coordinate(private val row: Int, private val col: Int) {

    fun layMine(field: Field): Field {
        return field.layMine(row, col)
    }

}