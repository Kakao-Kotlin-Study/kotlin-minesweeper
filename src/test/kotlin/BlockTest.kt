import domain.Block
import domain.Mine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BlockTest {
    @ParameterizedTest
    @DisplayName("row는 양의 정수여야 한다.")
    @ValueSource(ints = [0, -1])
    fun test1(row : Int){
        Assertions.assertThrows(IllegalArgumentException::class.java){ Block(row, 1) };
    }

    @ParameterizedTest
    @DisplayName("col는 양의 정수여야 한다.")
    @ValueSource(ints = [0, -1])
    fun test2(col : Int){
        Assertions.assertThrows(IllegalArgumentException::class.java){ Mine(Block(1, col)) };
    }
}