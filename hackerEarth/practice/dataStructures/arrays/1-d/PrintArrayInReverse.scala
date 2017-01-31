object PrintArrayInReverse extends App {
    val in = io.Source.stdin.getLines()
    val size = in.next.toInt
    val arr = Array.ofDim[Int](size)
    for(i <- 0 until size){
        arr(i) = in.next.toInt
    }
    (size - 1  to 0 by -1).foreach(i => println(arr(i)))
}