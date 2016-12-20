import scala.util.Sorting

object Solution extends App {
  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  var p = sc.nextInt();
  var a = new Array[Int](n);
  for(a_i <- 0 to n-1) {
     a(a_i) = sc.nextInt();
  }
  a = a.map((x:Int) => (x.toFloat/p).ceil.toInt)
  Sorting.quickSort(a)
  var lastVal = -1
  var sum = 0
  var solution = a.map((x:Int) => {
    lastVal = if (x > lastVal) {
      x
    }else {
      lastVal + 1
    }
    sum += lastVal
  })
  println(sum)
}
