//Accepted
object Solution extends App{
  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  val p = sc.nextInt();
  n = if (n % 2 == 0) n+1 else n
  val fromFront: Int = p / 2
  val fromBack: Int = (n-p)/2
  println(fromFront min fromBack)
}
