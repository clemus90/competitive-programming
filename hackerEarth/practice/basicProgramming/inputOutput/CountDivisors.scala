object CountDivisors extends App {
  val in = io.Source.stdin.getLines()
  val Array(l, r, k) = in.next().split(" ").map(_.toInt)
  println((l to r).filter(_ % k == 0).toList.size)
}
