object BobAndBombs extends App {

  val in = io.Source.stdin.getLines()
  val t = in.next.toInt
  for(_ <- (1 to t)){
    val mapping = "  " + in.next + "  "
    var count = 0
    for (i <- (2 until mapping.size - 2)){
      if(mapping.charAt(i) == 'W'){
        if(mapping.substring(i-2, i+3).exists(_ == 'B')) count += 1
      }
    }
    println(count)
  }
}
