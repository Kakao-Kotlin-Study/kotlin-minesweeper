import domain.FieldGenerator
import domain.RowNum
import domain.MineCount
import domain.ColNum
import view.In
import view.Out

fun main(args: Array<String>) {
    val rowNum = getRowNum()
    val colNum = getColNum()
    val mineCount = getMineCount(rowNum, colNum)
    val field = FieldGenerator.generate(rowNum, colNum, mineCount)
    Out.printMine(field)
}

fun getRowNum(): RowNum {
    Out.printHeightRequest()
    val height = In.getHeight()
    return RowNum(height)
}

fun getColNum(): ColNum {
    Out.printWidthRequest()
    val width = In.getWidth()
    return ColNum(width)
}

fun getMineCount(rowNum: RowNum, colNum: ColNum): MineCount {
    Out.printCountRequest()
    val mineCount = In.getMineCount()
    return MineCount(mineCount, rowNum, colNum)
}