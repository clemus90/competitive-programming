object MinMax extends App{
  val in = io.Source.stdin.getLines()
  val n = in.next.toInt
  val nums = in.next.split(" ").map(_.toInt)
  val min = nums.reduceLeft(_ min _)
  val max = nums.reduceLeft(_ max _)
  println(if ((min to max).forall(nums contains _)) "YES" else "NO")
}
