object CandyReplenishingRobot extends App{
    def sim(n:Int, turns:Vector[Int]): Int = {
        def rec(bowlEnd:Int, rem:Vector[Int], acum:Int): Int = rem match {
            case h +: Vector() => acum
            case h +: t => if((bowlEnd - h) < 5) rec(n, t, acum + (n - (bowlEnd - h)))
            else rec(bowlEnd - h, t, acum)
        }
        rec(n, turns, 0)
    }
    val in = io.Source.stdin.getLines()
    val Array(n, t) = in.next.split(" ").map(_.toInt)
    val turns = in.next.split(" ").map(_.toInt).toVector
    println(sim(n, turns))
}