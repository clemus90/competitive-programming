object RoysLifeCycle extends App {
  val in = io.Source.stdin.getLines()
  val days = in.next.toInt
  var longestCodingBetweenDays = 0
  var longestCodingOnADay = 0
  var wideCodingCount = 0
  for(x <- 1 to days){
    var dayCodingCount = 0
    in.next.foreach(x => {
      if(x == 'C'){
        wideCodingCount += 1
        dayCodingCount += 1
        if(wideCodingCount > longestCodingBetweenDays) longestCodingBetweenDays = wideCodingCount
        if(dayCodingCount > longestCodingOnADay) longestCodingOnADay = dayCodingCount
      }else{
        wideCodingCount = 0
        dayCodingCount = 0
      }
    })
  }
  println(s"$longestCodingOnADay $longestCodingBetweenDays")
}
