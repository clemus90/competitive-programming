object GameOfTwoStacks extends App {

    val in = io.Source.stdin.getLines()
    for(_ 1 to in.next.toInt){
        val Array(s1Size, s2Size, sum) = in.next.split(" ").map(_.toInt)
        val f = (acum, x) => acum match {
            case Nil => acum :+ x.toInt
            case v:Vector[Int] => acum :+ v.last + x.toInt
        })
        val acumS1 = in.next.split(" ").foldLeft(Vector[Int].empty)(f)
        val acumS2 = in.next.split(" ").foldLeft(Vector[Int].empty)(f)

        var max = 0
        for{i <- 1 until acum.S1.size
            j <- 1 until acum.S2.size}{
            
        }
    }
}