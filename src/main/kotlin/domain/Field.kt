package domain

class Field(private val field: MutableList<Row>) {

    fun layMine(rowNum: Int, colNum: Int): Field {
        field[rowNum].setMine(colNum)
        return Field(field)
    }

    fun getRowString(): String {
        val sb: StringBuilder = StringBuilder()
        field.asSequence().forEach { sb.append(it.getString()).append("\n") }
        return sb.toString()
    }

}