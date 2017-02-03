import scala.util.Random

object QuickSort extends App {
    def quickSort(arr: Array[Long]): Array[Long] = {
        if(arr.length <= 1) arr
        else {
            val pivot = Random.nextInt(arr.length)
            Array.concat(
                quickSort(arr.filter(_<arr(pivot))),
                arr.filter(_==arr(pivot)),
                quickSort(arr.filter(_>arr(pivot)))
            )
        }
    }

    val in = io.Source.stdin.getLines()
    in.next // Size not needed
    println(quickSort(in.next.split(" ").map(_.toLong)).mkString(" "))
}