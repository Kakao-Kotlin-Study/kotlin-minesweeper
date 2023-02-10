package domain

import view.InputView
import view.OutputView

class MineSweeperSimulator(private val inputView: InputView
    , private val outPutView : OutputView
    , private val blockGenerator: BlockGenerator) {
    fun start() {
        val mineSweeperWidth : Int = inputView.getMineMapHeight();
        val mineSweeperHeight : Int = inputView.getMineMapWidth();
        val mineNumbers : Int = inputView.getMineNumbers();

        val mineSweeperMap = MineSweeperMap(mineSweeperHeight, mineSweeperHeight)
        (0 until mineNumbers)
            .forEach{mineSweeperMap.installMine(blockGenerator)}


        outPutView.printMap(mineSweeperMap);
    }
}