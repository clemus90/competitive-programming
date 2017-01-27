object RhezoAndCharacterFrequency extends App {
  val in = io.Source.stdin.getLines()
  val s = in.next
  val c = in.next.charAt(0)
  val p = in.next.toInt

  val countCharFromPos = (s: String, pos: Int, length: Int, c: Char) => {
    val beg = pos
    val end = if(pos + length <= s.size)pos + length - 1 else s.size - 1
    val res = (beg to end).foldLeft(0)((acum, x) => if(s.charAt(x) == c) acum + 1 else acum)
    val maximize = if(s.charAt(end) != c || end - beg < length - 1) res + 1
      else res
    (res, maximize)
  }

  println(s.size)

  val ccfp = (countCharFromPos(s, _:Int, p, c))
  val maxF = (0 until s.size).foldLeft((0,0,-1))((acum, x) =>{
    val current = ccfp(x)
    if(current._1 >= acum._1 && current._2 >= acum._2){
      (current._1, current._2, x)
    }
    else acum
  })
  val posToAdd = if(maxF._1 == maxF._2) -1 else if((maxF._3 + p - 1) > s.size) s.size else maxF._3 + p - 1
  println(posToAdd)
}
