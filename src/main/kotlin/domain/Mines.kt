package domain

class Mines (val mines : List<Mine>){
    constructor(blocks : Blocks) : this(blocks.blocks.map { Mine(it) })

    val blocks : Blocks
        get() {
            return Blocks(mines.map { mine -> mine.block})
        }

    val size : Int
        get(){
            return mines.size
        }

    fun isExistSameLocation(block: Block): Boolean{
        return blocks.contains(block);
    }

    fun isWithInSquare(leftUpper : Block, rightLower : Block): Boolean {
        return blocks.isWithInSquare(leftUpper, rightLower);
    }

    fun add(mine: Mine): Mines {
        val minesCopy = mines.toMutableList();
        minesCopy.add(mine)
        return Mines(minesCopy)
    }
}