object CricketRating extends App {
  val in = io.Source.stdin.getLines()
  val tam = in.next.toInt
  if(tam == 0) println(0)
  else println(in.next.split(" +").map(_.toInt).foldLeft((0,0))((acum, n) => {
    val bestNSum = if((acum._2 + n) > n) acum._2 + n else n
    val max = if(bestNSum > acum._1) bestNSum else acum._1
    (max, bestNSum)
  })._1)
}
