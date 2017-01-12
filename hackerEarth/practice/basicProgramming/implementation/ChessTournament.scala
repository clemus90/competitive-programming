object ChessTournament extends App {

  def play(matches: Vector[Vector[Int]], vs: Vector[Vector[Int]]): Int = {
    val winners: Vector[Int] = matches.foldLeft(Vector.empty: Vector[Int])((acum, x) => {
      if(vs(x(1))(x(0)) == 1) acum :+ x(1)
      else acum :+ x(0)
    })
    if(winners.size == 1)winners(0)
    else play(winners.sliding(2,2).toVector, vs)

  }

  val in = io.Source.stdin.getLines()
  val n = in.next.toInt
  val dim = math.pow(2,n).toInt
  var vs: Vector[Vector[Int]] = Vector.fill(2)(Vector(-1))
  for (row <- 2 to dim){
    val data: Vector[Int] = -1 +: in.next.split(" ").map(_.toInt).toVector
    vs = vs :+ data
  }
  println(play((1 to dim).toVector.sliding(2,2).toVector, vs))
}
