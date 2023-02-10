package domain;

class MineSweeperMap(height : Int, width : Int) {
    private var mines : Mines
        private set

    private val width : Width
    private val height : Height

    companion object{
        private const val NOT_MINE = '.'

        private const val MINE = '#'
    }

    val leftUpper : Block get() = Block(Block.MIN_ROW, Block.MIN_COL)

    val rightLower : Block get() = Block(height.value, width.value)

    val totalBlockNums : Int get() = width.value * height.value

    val maxRow : Int get() = rightLower.row
    val maxCol : Int get() = rightLower.col

    val map : Array<CharArray>
        get(){
            val map : Array<CharArray> = Array(height.value) {_ -> CharArray(width.value){_ -> NOT_MINE}}
            mines.blocks
                .stream
                .forEach{block -> map[block.row - 1][block.col - 1] = MINE }

            return map
        }

    init{
        this.mines = Mines(listOf())
        this.width = Width(width)
        this.height = Height(height)
    }

    private fun isExistSameLocationMine(block : Block): Boolean = mines.isExistSameLocation(block)

    private fun isWithInMap(block : Block): Boolean = block.isWithInSquare(leftUpper, rightLower)

    private fun isInstallable() = mines.size < totalBlockNums

    fun installMine(blockGenerator: BlockGenerator){
        var block : Block

        if(!isInstallable()){
            throw IllegalArgumentException("Mines can no longer be placed.");
        }

        do{
            block = blockGenerator.generate(maxRow, maxCol)
        }while(isExistSameLocationMine(block));

        if(!isWithInMap(block)){
            throw IllegalArgumentException("Mines must exist on the map.");
        }

        mines = mines.add(Mine(block));
    }
}
