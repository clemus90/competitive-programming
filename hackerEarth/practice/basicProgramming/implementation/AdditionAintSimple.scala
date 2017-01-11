object AdditionAintSimple extends App{
  def addLetters(x: Char, y: Char): Unit = {
    val xBase = (x - 'a' + 1) % 26
    val yBase = (y - 'a') % 26
    print((((xBase + yBase) % 26) + 'a').toChar)
  }

  val in = io.Source.stdin.getLines()
  val n = in.next.toInt
  for(_ <- 1 to n){
    val entry = in.next
    entry.zip(entry.reverse).foreach((addLetters _).tupled)
    println()
  }
}
