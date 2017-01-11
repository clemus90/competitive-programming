object CountDigits extends App {
  def countDig(s: String): List[Int] = {
    def rec(s:List[Char], acum: List[Int]): List[Int] = {
      s match {
        case head :: tail => {
          if (head >= '0' && head <= '9'){
            val index = head - '0'
            rec(tail, acum.updated(index, acum(index) + 1))
          }else {
            rec(tail, acum)
          }
        }
        case _ => acum
      }
    }

    rec(s.toList, List.fill(10)(0))
  }

  val in = io.Source.stdin.getLines()
  for ( (x, i) <- countDig(in.next).zipWithIndex) println(i + " " + x)

}
