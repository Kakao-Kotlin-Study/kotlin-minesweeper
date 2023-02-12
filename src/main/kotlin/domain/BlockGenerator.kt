package domain

interface BlockGenerator {
    fun generate(maxRow : Int, maxCol : Int, num : Int) : List<Block>
    fun generate(maxRow: Int, maxCol: Int) : Block
}