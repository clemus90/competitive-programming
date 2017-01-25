import scala.annotation.tailrec

object JarvisAndNumbers extends App {
  def sumOfDigitsOnBaseN(number:Int, base:Int): Int = {
    @tailrec
    def rec(num:Int, acum:Int):Int = {
      if (num == 0) acum
      else {
        val digit = num % base
        val remains = num / base
        rec(remains, acum+digit)
      }
    }

    rec(number, 0)
  }

  @tailrec
  def gcd(a: Int, b: Int):Int = {
    if(a == 0)b
    else if(b == 0)a
    else gcd(b, a%b)
  }


  val in = io.Source.stdin.getLines()
  val tests = in.next.toInt
  for(_ <- (1 to tests)){
    val num = in.next.toInt
    val numerator = (2 to (num - 1)).map(x => sumOfDigitsOnBaseN(num, x)).reduce(_ + _)
    val denominator = num - 2
    println(denominator / gcd(numerator, denominator))
  }

}
