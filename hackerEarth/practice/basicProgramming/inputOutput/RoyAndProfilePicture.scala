object RoyAndProfilePicture extends App {
  val in = io.Source.stdin.getLines()
  val l = in.next().toInt
  val n = in.next().toInt
  for(_ <- 1 to n){
    val Array(w, h) = in.next().split(" ").map(_.toInt)
    println(if (w < l || h < l) "UPLOAD ANOTHER"
            else if(w == h) "ACCEPTED"
            else "CROP IT")
  }
}
