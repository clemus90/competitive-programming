object FindTheMinimumNumbers extends App{
    def minCalls(n:Int): String = n match {
        case 0 => throw new Exception("Invalid input")
        case 1 => throw new Exception("Invalid input")
        case 2 => "min(int, int)"
        case _ => "min(int, " + minCalls(n-1) + ")"

    }
    println(minCalls(io.Source.stdin.getLines().next.toInt))

}