package view

import domain.MineSweeperMap
import java.io.OutputStream

class OutputView(private val printStream : OutputStream) {
    fun printMap(mineSweeperMap: MineSweeperMap) {

        val map = mineSweeperMap.map;
            map.forEach { row ->
                row.forEach { value -> print(value) }
                println()
            }
    }
}