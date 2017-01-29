import scala.annotation.tailrec

object TheCastleGate extends App {
    val in = io.Source.stdin.getLines()
    for(_ <- 1 to in.next.toInt){
        var count = 0
        var n = in.next.toInt
        for(x <- 1 to n;
            y <- x + 1 to n) if ((x^y) <= n) count += 1
        println(count)
    }
}