object RangeModularQueries extends App {
    val in = io.Source.stdin.getLines
    val Array(size, queries) = in.next.split(" ").map(_.toInt)
    val arr = in.next.split(" ").map(_.toInt)
    for (_ <- 1 to queries){
        val Array(left, right, base, mod) = in.next.split(" ").map(_.toInt)
        println((left to right).foldLeft(0)((acum, x) => if (arr(x) % base == mod) acum + 1 else acum))
    }
}