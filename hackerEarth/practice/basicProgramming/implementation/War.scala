object War extends App {

  val in = io.Source.stdin.getLines()
  val t = in.next.toInt
  for(_ <- (1 to t)){
    val n = in.next.toInt
    val bobSt = in.next.split(" ").foldLeft(0)(_ max _.toInt)
    val aliceSt = in.next.split(" ").foldLeft(0)(_ max _.toInt)
    println(if(bobSt > aliceSt)"Bob"
    else if(aliceSt > bobSt)"Alice"
    else "Tie")
  }
}
