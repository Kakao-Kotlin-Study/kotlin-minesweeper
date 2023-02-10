import domain.Block
import domain.MineSweeperMap
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MineSweeperMapTest {
    @Test
    @DisplayName("맵을 벗어난 지뢰를 설치할 수 없다.")
    fun test1() {
        val blockGenerator = StubBlockGenerator(listOf(Block(2, 2)))
        val mineSweeperMap = MineSweeperMap(1, 1);

        Assertions.assertThrows(IllegalArgumentException::class.java)
            {mineSweeperMap.installMine(blockGenerator)}
    }

    @Test
    @DisplayName("맵에 존재하는 block보다 많은 지뢰를 설치할 수 없다.")
    fun test2() {
        val blockGenerator = StubBlockGenerator(listOf(Block(1, 1), Block(2, 2)))
        val mineSweeperMap = MineSweeperMap(1, 1);

        mineSweeperMap.installMine(blockGenerator)

        Assertions.assertThrows(IllegalArgumentException::class.java)
        {mineSweeperMap.installMine(blockGenerator)}
    }

}