package domain

class Field(private val field: MutableList<MutableList<Section>>) {

    private val delta = listOf(listOf(-1, -1), listOf(-1, 0), listOf(-1, 1), listOf(0, -1), listOf(0, 1), listOf(1, -1), listOf(1, 0), listOf(1, 1))

    fun layMine(rowNum: Int, colNum: Int): Field {
        field[rowNum][colNum] = Mine()
        delta.forEach {
            val newRow = rowNum + it[0]
            val newCol = colNum + it[1]
            if (newRow in 0 until field.size && newCol in 0 until field.size) {
                addIfSafe(field[newRow][newCol])
            }
        }
        return Field(field)
    }

    private fun addIfSafe(section: Section) {
        if (section is Safe) {
            section.add()
        }
    }

}