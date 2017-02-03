//Partially Accepted
object MergeSort extends App{

    def merge(l: Vector[Long], r: Vector[Long]) = {
        var left = l
        var right = r
        var result = Vector.empty[Long]
        var pairsFound = 0
        while(!left.isEmpty && !right.isEmpty){
            if(left.head <= right.head){
                result = result :+ left.head
                left = left.tail
            }else{
                result = result :+ right.head
                right = right.tail
                pairsFound += left.size
            }
        }
        if(!left.isEmpty){
            result = result ++ left
        }
        if(!right.isEmpty){
            result = result ++ right
        }
        (result, pairsFound)
    }

    def mergeSort(list: Vector[Long]): (Vector[Long], Long) = {
        if(list.size > 1){
            val mid = list.size / 2
            val (splitLeft, splitRight) = list.splitAt(mid)
            val left = mergeSort(splitLeft)
            val right = mergeSort(splitRight)
            val m = merge(left._1, right._1)
            (m._1, m._2 + left._2 + right._2)
        }else{
            (list, 0)
        }
    }

    val in = io.Source.stdin.getLines()
    val size = in.next.toLong
    val arr = in.next.split(" ").map(_.toLong).toVector
    println(mergeSort(arr)._2)
}