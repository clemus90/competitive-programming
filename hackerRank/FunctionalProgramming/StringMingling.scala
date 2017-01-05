import scala.annotation.tailrec

object Solution extends App {
  @tailrec
  def mingling(s1: String, s2: String): Unit = {
    if (s1.size != 0){
      print(s1.head)
      print(s2.head)
      mingling(s1.tail, s2.tail)
    }
  }
  val words = io.Source.stdin.getLines().take(2)
  mingling(words.next, words.next)
  println()
}
