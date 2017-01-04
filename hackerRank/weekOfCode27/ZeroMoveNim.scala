//Wrong answer for the majority of the cases
object Solution extends App {
  def gameOfNimWiner(a: Vector[Int], piles: Int): Boolean = {
    val nim = a reduceLeft ((acum: Int, x: Int) => acum ^ x)
    (nim !=0 && piles % 2 == 0) || (nim == 0 && piles % 2 == 1)
  }


  val sc = new java.util.Scanner(System.in)
  val g = sc.nextInt()
  for (game <- 1 to g) {
    val n = sc.nextInt()
    var p: Vector[Int] = Vector.empty
    for(i <- 1 to n){
      p = sc.nextInt() +: p
    }
    if(gameOfNimWiner(p, n)) {
      println("W")
    }else{
      println("L")
    }
  }
}
