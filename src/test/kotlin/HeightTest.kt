import domain.Height
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, -2])
    @DisplayName("value는 0이상 이어야한다.")
    fun test1(value : Int){
        Assertions.assertThrows(IllegalArgumentException::class.java){ Height(value) };
    }
}