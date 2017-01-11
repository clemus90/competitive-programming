object LifeTheUnvierseAndEverything extends App {
  val in = io.Source.stdin.getLines()
  var last = 0
  while(in.hasNext && last != 42){
    last = in.next().toInt
    if (last != 42) println(last)
  }
}
