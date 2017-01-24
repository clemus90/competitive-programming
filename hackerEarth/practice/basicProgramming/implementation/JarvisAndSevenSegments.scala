object JarvisAndSevenSegments extends App {
  val in = io.Source.stdin.getLines()
  val tests = in.next.toInt
  val neededBulbs = Vector(6,2,5,5,4,5,6,3,7,6)
  for(_ <- 1 to tests){
    in.next.toInt // not needed length
    val favs = in.next.split(" ")
    val consumption: Vector[Int] = favs.map(_.toList.map(_.toInt - '0'.toInt).foldLeft(0)(_ + neededBulbs(_))).toVector
    val fav = (0 until consumption.length).reduce((acum, x) => {
      if(consumption(x) < consumption(acum))x
      else acum
    })
    println(favs(fav))
  }
}
