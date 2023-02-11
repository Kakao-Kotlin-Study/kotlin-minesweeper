package domain

class Row(private val row: MutableList<Section>) {

    fun setMine(idx: Int): Row {
        row[idx] = Mine()
        return Row(row)
    }

    fun getString(): String {
        val sb: StringBuilder = StringBuilder()
        row.asSequence().forEach { sb.append(it.icon).append("  ") }
        return sb.toString()
    }

}