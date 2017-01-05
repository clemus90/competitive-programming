object Solution extends App {
  def f(num: Int): List[Int] = {
    if (num == 0) Nil else (1 to num).toList
  }
}
