object FinalDestination extends App {

  val in = io.Source.stdin.getLines()
  println(in.next.foldLeft((0,0))( (pos,move) => move match {
    case 'L' => (pos._1 - 1, pos._2)
    case 'R' => (pos._1 + 1, pos._2)
    case 'U' => (pos._1 , pos._2 + 1)
    case 'D' => (pos._1 , pos._2 - 1)
  }) match {case(x, y) => s"$x $y"})
}
