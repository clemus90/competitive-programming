import scala.annotation.tailrec

//Accepted
object Solution extends App{

  def hackonacciVals(n: Long): Array[Boolean] = {
    val size = 7
    var result = Array.fill(size){false}
    result(1) = false
    result(2) = true
    result(3) = false
    //Periodicity of size 7
    for(i <- 4 to 6){
      //1.hackonacci(n-1) + 2.hackonacci(n-2) + 3.hackonacci(n-3)
      //2nd operator is always pair, so whether the result is true or False
      //depends on the other 2 operands, specifically, if both are equal
      // the result is pair, otherwise the result is odd
      result(i) = result(i-1) == result(i-3)
    }
    result
  }
  implicit class HackonacciComparable(h: Array[Boolean]){
    def hackonacciValue(v: Int): Boolean = {
      h(( (v % 7) * (v % 7)) % 7)
    }
  }
  def numberOfChangesPerSpin(m: Array[Boolean],size: Int): (Int,Int,Int,Int)= {
    size match {
      case 0 | 1 => (0,0,0,0)
      case _ => {
        var (spin1, spin2, spin3) = (0,0,0)
        for (i <- 1 to size){
          for (j <- 1 to size){
            spin1 += (if( m.hackonacciValue(i*j) != m.hackonacciValue(i * (size - (j-1))) ) 1 else 0)
            spin2 += (if( m.hackonacciValue(i*j) != m.hackonacciValue((size - (i-1)) * (size - (j-1))) ) 1 else 0)
            spin3 += (if( m.hackonacciValue(i*j) != m.hackonacciValue((size - (i-1)) * j) ) 1 else 0)
          }
        }
        (0,spin1,spin2,spin3)
      }
    }
  }

  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  val isHackonacciPair = hackonacciVals(n.toLong)
  val results = numberOfChangesPerSpin(isHackonacciPair, n)
  var q = sc.nextInt();
  var a0 = 0;
  while(a0 < q){
    var angle = sc.nextInt() / 90 % 4;
    println(angle match {
      case 1 =>  results._2
      case 2 =>  results._3
      case 3 =>  results._4
      case _ =>  results._1
    })
    a0 += 1;
  }

}
