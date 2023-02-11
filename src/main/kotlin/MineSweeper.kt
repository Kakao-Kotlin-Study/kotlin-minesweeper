import domain.Spec
import view.In
import view.Out

fun main(args: Array<String>) {

    val spec = getSpec()
    val field = spec.makeField()
    Out.printMine(field)

}

fun getSpec(): Spec {
    Out.printHeightRequest()
    val height = In.getHeight()
    Out.printWidthRequest()
    val width = In.getWidth()
    Out.printCountRequest()
    val count = In.getCount(height, width)
    count.makeRandomCoordinates()
    return Spec(height, width, count)
}