import domain.Field
import domain.FieldGenerator
import view.In
import view.Out

fun main(args: Array<String>) {
    val field = makeField()
    Out.printMine(field)
}

fun makeField(): Field {
    Out.printHeightRequest()
    val height = In.getHeight()
    Out.printWidthRequest()
    val width = In.getWidth()
    Out.printCountRequest()
    val count = In.getCount(height, width)
    return FieldGenerator(height, width, count).generate()
}