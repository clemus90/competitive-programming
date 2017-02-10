import scala.annotation.tailrec

object LastOccurrence extends App{

    @tailrec
    def findLast(arr: Array[Int], num: Int, pos: Int): Int = {
        if(pos < 0) -2
        else{
            if(arr(pos) == num) pos
            else findLast(arr, num, pos - 1)
        }
    }

    val in = io.Source.stdin.getLines()
    val Array(n, m) = in.next.split(" ").map(_.toInt)
    val arr = in.next.split(" ").map(_.toInt)
    println(findLast(arr, m, arr.size - 1) + 1)

}