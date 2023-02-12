import domain.Block
import domain.BlockGenerator

class StubBlockGenerator(private val blocks : List<Block>) : BlockGenerator{
    private var blockIndex = 0;
    override fun generate(maxRow: Int, maxCol: Int, num: Int): List<Block> {
        blockIndex += num
        return blocks
            .slice(blockIndex until blockIndex + num)
    }

    override fun generate(maxRow: Int, maxCol: Int): Block {
        return blocks.get(blockIndex++)
    }
}