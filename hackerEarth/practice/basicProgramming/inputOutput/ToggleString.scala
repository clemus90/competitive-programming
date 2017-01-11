object ToggleString extends App {
  val in = io.Source.stdin.getLines()
  val s = in.next()
  val loP = "([a-z])".r
  val upP = "([A-Z])".r

  print(s.map(c => c.toString match {
    case loP(temp) => temp.toUpperCase
    case upP(temp) => temp.toLowerCase
    case x => x
  }).mkString(""))

}
