object Factorial extends App {
  val in = io.Source.stdin.getLines()
  val n = in.next().toInt
  println((1 to n).reduceLeft((x,y) => x * y))
}
