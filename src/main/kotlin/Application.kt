import domain.MineSweeperSimulator
import domain.RandomBlockGenerator
import view.InputView
import view.OutputView

fun main() {
    val inputStream = System.`in`;
    val printStream = System.out;
    val inputView  = InputView(inputStream, printStream);
    val outputView = OutputView(printStream);

    val simulator = MineSweeperSimulator(inputView, outputView, RandomBlockGenerator());
    simulator.start()
}