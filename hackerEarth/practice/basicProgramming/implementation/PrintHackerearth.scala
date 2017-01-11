object PrintHackerearth extends App{
  def buildRepetitionMap(s: String):Map[Char, Int] = {
    var ret = Map[Char, Int]()
    for(x <- s){
      ret = ret + (x -> (ret.getOrElse(x,0) + 1))
    }
    ret
  }

  val in = io.Source.stdin.getLines()
  val expected = buildRepetitionMap("hackerearth")
  val length = in.next
  val test = buildRepetitionMap(in.next)
  println(expected.foldLeft(Int.MaxValue)((acum, x) => {
    val letterRep = (test.getOrElse(x._1,0) / x._2)
    if(letterRep < acum) letterRep
    else acum
  }))

}
