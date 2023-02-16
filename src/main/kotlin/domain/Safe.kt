package domain

class Safe : Section {
    var mineDensity: Int = 0

    fun add() {
        mineDensity++
    }
}