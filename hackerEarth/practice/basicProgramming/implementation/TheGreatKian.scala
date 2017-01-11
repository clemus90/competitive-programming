object TheGreatKian extends App {
  val in = io.Source.stdin.getLines()
  val n = in.next.toInt
  val result = in.next.split(" ").toList.map(_.toLong).sliding(3,3).
    foldLeft(List(0L, 0L, 0L))((acum, x) => {

      var (first, second, third) = (acum(0), acum(1), acum(2))

      if (x.size >= 1) first = first + x(0)
      if (x.size >= 2) second = second + x(1)
      if (x.size == 3) third = third + x(2)
      List(first, second, third)
    })
  println(result(0) + " " + result(1) + " " + result(2))
}
