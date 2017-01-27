object PerfectBaseline extends App {
  val in = io.Source.stdin.getLines()
  val tests = in.next.toInt
  for(_ <- 1 to tests){
    val Array(n, k) = in.next.split(" ").map(_.toInt)
    val letterCount = for(_ <- 1 to k) yield Array.fill[Int](26)(0)
    for(_ <- 1 to n){
      in.next.toList.zipWithIndex.foreach(data => {
        letterCount(data._2)(data._1 - 'a') += 1
      })
    }
    println(letterCount.map(letters => ((letters.reduce(_ + _) / letters.size) + 'a').toChar).mkString(""))
  }
}
