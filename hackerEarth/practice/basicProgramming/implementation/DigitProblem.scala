object DigitProblem extends App {
  val in = io.Source.stdin.getLines()
  val Array(x, kString) = in.next.split(" ")
  val k = kString.toInt
  var count = 0
  println(x.map(x => {
    if(count < k && x != '9'){
      count += 1
      '9'
    }else{
      x
    }
  }))
}
