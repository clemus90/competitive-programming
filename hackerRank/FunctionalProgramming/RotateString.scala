object Solution extends App {

  val in = io.Source.stdin.getLines()
  val n = in.next.toInt
  for (c <- (1 to n)){
    val s = in.next
    (1 to s.size).foreach(
      x => {
        print(s.substring(x))
        print(s.take(x))
        if(x != s.size)print(" ")
      }
    )
    println()
  }
}
