object LittleJhoolPsychicPowers extends App{
  val in = io.Source.stdin.getLines()
  val num = in.next
  if (num.size < 6) println("Good luck!")
  else {
    var founded = false;
    num.sliding(2).foldLeft(1)((acum,x) => {
      if (acum >= 6) founded = true
      if(x(0) != x(1)){
        1
      }else{
        acum + 1
      }
    })
    if(founded) println("Sorry, sorry!")
    else println("Good luck!")
  }
}
