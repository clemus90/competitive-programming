object FindingMino extends App {
    val in = io.Source.stdin.getLines()

    def f(x:Double) = 2 * x * x - 12 * x + 7

    def ts(start:Int, end:Int):Double = {
        var l = start
        var r = end
        for(_ <- 1 to 400){
            val l1 = (l*2+r)/3
            val l2 = (l+2*r)/3
            if(f(l1) < f(l2)) r = l2 else l = l1
        }

        f(l)
    }

    for(_ <- 1 to in.next.toInt){
        val Array(start, end) = in.next.split(" ").map(_.toInt)
        println(ts(start,end).toInt)
    }
}