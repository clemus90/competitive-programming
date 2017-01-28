import scala.annotation.tailrec

object PerfectBaseline extends App {

  def median(arr: Array[Int], total: Int):Char = {
    
    def search(occurrence: Int): Int = {
      @tailrec
      def rec(pos:Int, acum:Int):Int = {
        if(acum+arr(pos) >= occurrence)pos
        else rec(pos+1, acum + arr(pos))
      }

      rec(0,0)
    }

    var currentTotal = 0
    val totals = arr.map(x => {
      currentTotal += x
      currentTotal
    })

    if(total % 2 == 1) (search((total/2) + 1) + 'a').toChar
    else (search(total/2) + 'a').toChar

  }

  val in = io.Source.stdin.getLines()
  val tests = in.next.toInt
  for(_ <- 1 to tests){
    val Array(n, k) = in.next.split(" ").map(_.toInt)
    val letterCount = for(_ <- 1 to k) yield Array.fill[Int](26)(0)
    for(_ <- 1 to n){
      in.next.toList.zipWithIndex.foreach(data => {
        letterCount(data._2)(data._1 - 'a') += 1
      })
    }
    println(letterCount.map(median(_, n)).mkString(""))
  }
}
