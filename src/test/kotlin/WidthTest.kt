import domain.Width
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WidthTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, -2])
    @DisplayName("value는 0 이상이어야한다.")
    fun test1(value : Int){
        Assertions.assertThrows(IllegalArgumentException::class.java){ Width(value) };
    }
}