import scala.annotation.tailrec

object SamuAndCardGame extends App {

  def validPos(vector: (Long, Long), board: (Long, Long)) = {
    vector._1 >=1 && vector._1 <= board._1 && vector._2 >= 1 && vector._2 <= board._2
  }

  def sum(vector: (Long, Long), other: (Long, Long)) = {
    (vector._1 + other._1, vector._2 + other._2)
  }

  def validJumps(board: (Long, Long), jumps: Seq[(Long, Long)]) = {
    @tailrec
    def rec(currPos:(Long, Long), jump:Int, count: Long): Long = {
      if(jump >= jumps.size) count
      else{
        val newPos = sum(currPos,jumps(jump))
        if(validPos(newPos, board)) rec(newPos, jump , count + 1)
        else rec(currPos, jump + 1, count)
      }
    }

    rec((1,1), 0, 0)
  }

  val in = io.Source.stdin.getLines()
  val tc = in.next.toInt
  for(_ <- 1 to tc){
    val Array(n, m)= in.next.split(" ").map(_.toLong)
    val board = (n,m)
    val k = in.next.toInt
    val jumps = for(_ <- (1 to k)) yield {
      val line =  in.next
      val Array(a, b) = line.split(" ").map(_.toLong)
      (a, b)
    }
    println(validJumps(board, jumps))
  }
}
