object FindProduct extends App {
  val in = io.Source.stdin.getLines()
  val n = in.next().toInt
  print((for{x <- in.next().split(" ")} yield x.toLong).reduce((x, y) => ((x * y) % (math.pow(10,9).toLong + 7))))
}
