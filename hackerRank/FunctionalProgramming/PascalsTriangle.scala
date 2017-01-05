object Solution extends App {
  def nextLevel(l: List[Int]): List[Int] = {
    if(l == Nil) List(1)
    else if(l == List(1)) List(1,1)
    else  List(1) ++ (1 until l.size).map(i => l(i) + l(i-1)).toList :+ 1

  }

  io.Source.stdin.getLines().take(1).foreach(x => {
    var lastList: List[Int] = Nil
    (1 to x.toInt).foreach(_ => {
      lastList = nextLevel(lastList)
      println(lastList.mkString(" "))
    })
  })

}
