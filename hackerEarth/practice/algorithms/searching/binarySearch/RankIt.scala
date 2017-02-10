object RankIt extends App {

    def binarySearch(arr: Array[Int], start: Int, end: Int, num: Int): Int = {
        if(start <= end){
            val mid = (end + start)/2
            if(arr(mid) > num) binarySearch(arr, start, mid - 1, num)
            else if(arr(mid) < num) binarySearch(arr, mid + 1, end, num)
            else mid
        }else{
            -1
        }
    }

    val in = io.Source.stdin.getLines()
    in.next //ignore size
    val arr = in.next.split(" ").map(_.toInt)
    scala.util.Sorting.quickSort(arr)
    val queries = in.next.toInt
    for(_ <- 1 to queries){
        val q = in.next.toInt
        println(binarySearch(arr, 0, arr.size - 1, q) + 1)
    }
}