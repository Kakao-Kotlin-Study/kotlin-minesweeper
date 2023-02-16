package domain

class Coordinates(private val coords: List<Coordinate>) {

    fun layMines(field: Field): Field {
        coords.forEach { it.layMine(field) }
        return field
    }

}