package domain

data class Block(val row : Int, val col : Int) {
    companion object {
        const val MIN_ROW = 1
        const val MIN_COL = 1
    }

    init{
        if(isInvalidRow()){
            throw IllegalArgumentException("Invalid Row");
        }

        if(isInValidColumn()){
            throw IllegalArgumentException("Invalid Column");
        }
    }

    private fun isInvalidRow() = row < MIN_ROW

    private fun isInValidColumn() = col < MIN_COL

    fun isWithInSquare(leftUpper: Block, rightLower: Block) : Boolean{
        return (leftUpper.row <= row &&  row <= rightLower.row)
                && (leftUpper.col <= col && col <= rightLower.col)
    }
}