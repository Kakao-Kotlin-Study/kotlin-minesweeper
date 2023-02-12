package domain

class RandomBlockGenerator : BlockGenerator {
    override fun generate(maxRow: Int, maxCol: Int, num: Int): List<Block> {
        return (0 until num)
            .map{generate(maxRow, maxCol)}
    }

    override fun generate(maxRow: Int, maxCol: Int) : Block{
        return Block(generateRow(maxRow), generateCol(maxCol))
    }

    private fun generateRow(maxRow : Int) : Int{
        return (Block.MIN_ROW..maxRow).random()
    }

    private fun generateCol(maxCol : Int) : Int{
        return (Block.MIN_COL..maxCol).random()
    }
}