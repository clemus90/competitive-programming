object BreakingTheRecords extends App{
    val in = io.Source.stdin.getLines()
    in.next // ignore size
    val scores = in.next.split(" ").map(_.toInt)
    val breakMin = scores.foldLeft((Integer.MAX_VALUE, -1))((acum, x) => {
        if(x < acum._1) (x, acum._2 + 1)
        else acum
    })._2
    val breakMax = scores.foldLeft((-1, -1))((acum, x) => {
        if(x > acum._1) (x, acum._2 + 1)
        else acum
    })._2
    println(s"$breakMax $breakMin");
    
}