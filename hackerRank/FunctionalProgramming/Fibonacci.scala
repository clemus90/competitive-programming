object Solution extends App {
  def fib(n: Int): Int = {
    if(n == 1) 0
    else if(n == 2) 1
    else fib(n-1) + fib(n-2)
  }

  io.Source.stdin.getLines().take(1).foreach(x => println(fib(x.toInt)))

}
