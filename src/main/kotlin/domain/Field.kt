package domain

class Field(private val field: MutableList<MutableList<Section>>) {

    fun layMine(rowNum: Int, colNum: Int): Field {
        field[rowNum][colNum] = Mine()
        return Field(field)
    }

    fun getRowString(): String {
        val sb: StringBuilder = StringBuilder()
        field.asSequence().forEach { sb.append(it.getString()).append("\n") }
        return sb.toString()
    }

}