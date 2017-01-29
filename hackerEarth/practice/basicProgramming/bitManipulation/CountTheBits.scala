import scala.annotation.tailrec

object CountTheBits extends App {
    @tailrec
    def countBits(n:Int, acum:Int): Int = {
        if(n == 0) acum
        else countBits(n & n-1, acum + 1)
    }
    val in = io.Source.stdin.getLines()
    for(_ <- 1 to in.next.toInt)println(countBits(in.next.toInt, 0))
}