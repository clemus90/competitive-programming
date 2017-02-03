object CountingSort extends App{
    val in = io.Source.stdin.getLines()
    val counter = Array.ofDim[Int](Math.pow(10,5).toInt + 1)
    in.next // ignore size
    in.next.split(" ").foreach(x => counter(x.toInt) += 1)
    for(x <- 0 until counter.size){
        val counterVal = counter(x)
        if(counterVal != 0)println(s"$x $counterVal")
    }
}