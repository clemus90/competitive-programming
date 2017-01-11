object MagicalWord extends App {

  def primesTo(n: Int): List[Int] = {
    def rec(i: Int, primes: List[Int]): List[Int] = {
      if (i > n) primes
      else {
        if (primes.forall(i % _ != 0)) rec(i+1, primes :+ i)
        else rec(i+1, primes)
      }
    }

    rec(2, List.empty[Int])
  }

  val maxVal = 126
  val primes = primesTo(maxVal).filter(x => (x >= 65 && x <= 90) || (x >= 97 && x <= 122))

  val in = io.Source.stdin.getLines()
  var c = in.next.toInt
  for(_ <- 1 to c){
    val length = in.next
    val word = in.next
    val nearestPrime = (n:Int) => {
      primes.foldLeft(1000)((acum, x) => {
        val dist = math.abs(n-x)
        val antDist = math.abs(n-acum)
        if(dist < antDist) x
        else acum
      })
    }
    println(word.map(c => nearestPrime(c.toInt).toChar))
  }
}
