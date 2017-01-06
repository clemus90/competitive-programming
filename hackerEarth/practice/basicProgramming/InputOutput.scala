object HelloWorld extends App {
  val in = io.Source.stdin.getLines()
  println(in.next.toInt * 2)
  println(in.next)
}
