object FindingMino extends App {
    val in = io.Source.stdin.getLines()

    def f(x:Double) = 2 * x * x - 12 * x + 7

    def ts(start:Double, end:Double):Long = {
        var l = start
        var r = end
        for(_ <- 1 to 100){
            val l1 = l + (r-l)/3
            val l2 = r - (r-l)/3
            if(f(l1) < f(l2)) r = l2 else l = l1
        }
        Math.round(f(l) min f(r))
    }

    for(_ <- 1 to in.next.toInt){
        val Array(start, end) = in.next.split(" ").map(_.toInt)
        println(ts(start,end))
    }
}