object OversizedPancakeFlipper extends App {

  def flip(s: String, pos: Int, size: Int): String = {
    var switched = s.substring(pos, pos + size).map( x => if (x == '+') '-' else '+')
    s.substring(0,pos) + switched + s.substring(pos+size)   
  }

  def isSolution(s: String) = s.forall(_ == '+')

  val in = io.Source.stdin.getLines();
  val cases = in.next.toInt;
  for(i <- 1 to cases){
    val line = in.next.split(" ")
    val pancakes = line(0)
    val flipper = line(1).toInt
    val finalSwitch = (0 to (pancakes.length() - flipper)).foldLeft((pancakes, 0))((status, i) => {
      status match {
        case (current, switches) => {
          if(current.charAt(i) == '+') (current, switches)
          else (flip(current, i, flipper), switches + 1)
        }
      }
    })

    if(isSolution(finalSwitch._1)) println("Case #" + i + ": " + finalSwitch._2)
    else println("Case #" + i + ": IMPOSSIBLE")
  }
}