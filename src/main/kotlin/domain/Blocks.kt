package domain

import java.util.stream.Stream

class Blocks(val blocks: List<Block>) {
    val stream : Stream<Block>
        get() = blocks.stream()

    fun contains(block : Block): Boolean {
        return blocks.contains(block)
    }

    fun isWithInSquare(leftUpper: Block, rightLower: Block): Boolean {
        return blocks
            .all {block -> block.isWithInSquare(leftUpper, rightLower)};
    }
}