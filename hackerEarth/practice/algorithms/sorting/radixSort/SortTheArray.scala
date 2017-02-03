object SortTheArray extends App {

    def countSort(arr: Array[Long], place: Int): Array[Long] = {
        val freq = Array.ofDim[Int](10)
        val output = Array.ofDim[Long](arr.size)
        (0 until arr.size).foreach(x => {
            freq(((arr(x) / place)%10).toInt) += 1
        })
        (1 until 10 ).foreach(x => freq(x) += freq(x-1))
        (arr.size - 1 to 0 by -1).foreach( x => {
            output(freq(((arr(x) / place) % 10).toInt) - 1) = arr(x)
            freq(((arr(x) / place) % 10).toInt) -= 1
        })
        output

    }

    def radixSort(arr: Array[Long]) = {
        var m = arr.reduce(_ max _)
        var stages = arr
        var power = 1
        while( m > 0 ){
            stages = countSort(stages,power)
            println(stages.mkString(" "))
            power *= 10
            m /= 10
        }
    }

    val in = io.Source.stdin.getLines()
    in.next // ignore size
    radixSort(in.next.split(" ").map(_.toLong))
}