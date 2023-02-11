package domain

class Coordinates(private val coords: List<Coordinate>) {

    fun layMines(field: Field): Field {
        coords.asSequence().forEach { it.layMine(field) }
        return field
    }

}