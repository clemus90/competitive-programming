object TidyNumbers extends App {

  def lastTidy(num: List[Int]): List[Int] = num match {
    case Nil => List.empty[Int]
    case first :: Nil => List(first)
    case first :: rest =>
      val restTidy = lastTidy(rest)
      if(first <= restTidy.head) first :: restTidy
      else (first - 1) :: nines(restTidy.size) 
  }

  def nines(size: Int): List[Int] = size match {
    case 0 => List.empty[Int]
    case x => 9 :: nines(x-1)
  }

  def filterLeadingZeroes(num: List[Int]): List[Int] = num match {
    case Nil => List.empty[Int]
    case 0 :: t => filterLeadingZeroes(t)
    case x => x
  }

  val x = 3
  val in = io.Source.stdin.getLines()
  val cases = in.next.toInt;
  for(i <- 1 to cases){
    val number = in.next.toList.map(_.asDigit)
    println("Case #" + i + ": " + filterLeadingZeroes(lastTidy(number)).mkString)

    //if(isSolution(finalSwitch._1)) println("Case #" + i + ": " + finalSwitch._2)
    //else println("Case #" + i + ": IMPOSSIBLE")
  }
}