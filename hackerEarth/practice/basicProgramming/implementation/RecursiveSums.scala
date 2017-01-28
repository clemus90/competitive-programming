import scala.annotation.tailrec

object RecursiveSums extends App {

    @tailrec
    def recSum(digits: Array[Long]): Long = {
        digits.mkString(" ")
        if(digits.reduce(_ + _) == 1)(0 to 9).reduce((acum,x) => if(digits(x) != 0) x else acum)
        else {
            val newDigits = Array.fill[Long](10)(0) 
            (0 to 9).map(x => BigInt(digits(x))*BigInt(x))
                .reduce(_ + _).toString.map(x => (x - '0').toInt).foreach(newDigits(_) += 1)
            recSum(newDigits)
        }
    }

    val in = io.Source.stdin.getLines()
    val tests = in.next.toInt
    for(_ <- 1 to tests){
        val m = in.next.toInt
        val count = Array.fill[Long](10)(0)
        for(_ <- 1 to m){
            val Array(len, d) = in.next.split(" ").map(_.toLong)
            count(d.toInt) += len
        }
        println(recSum(count))
    }
}
