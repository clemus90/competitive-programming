object BubbleSort extends App {
    val in = io.Source.stdin.getLines()
    val size = in.next.toInt
    val array = in.next.split(" ").map(_.toInt)
    var switchCount = 0
    for(i <- 0 until (size - 1)){
        for(j <- 0 until (size - 1 - i)){
            if(array(j) > array(j+1)){
                switchCount += 1
                val temp = array(j)
                array(j) = array(j+1)
                array(j+1) = temp
            }
        }
    }
    println(switchCount)
}