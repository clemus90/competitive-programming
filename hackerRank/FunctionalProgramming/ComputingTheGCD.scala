object Solution extends App {
  def gcd(x: Int, y: Int): Int = {
    if(x == 0) y
    else if(y == 0) x
    else{
      val mi = List(x,y).min
      val ma = List(x,y).max
      gcd(mi, ma%mi)
    }
  }

  val params = readLine().trim().split(" ").map(x => x.toInt)
  println(gcd(params(0), params(1)))

}
