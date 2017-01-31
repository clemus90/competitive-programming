object Transpose extends App {
    val in = io.Source.stdin.getLines()
    val Array(rows, columns) = in.next.split(" ").map(_.toInt)
    val matrix: Array[Array[Int]] = (for(_ <- 1 to rows) yield {
        in.next.split(" ").map(_.toInt)
    }).toArray

    for(i <- 0 until columns) {
        for(j <- 0 until rows) {
            print(matrix(j)(i))
            if(j != rows - 1) print(" ")
        }
        println()
    }
}