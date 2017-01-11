object PalindromicString extends App {
  val in = io.Source.stdin.getLines()
  val s = in.next()
  print(if(s == s.reverse) "YES" else "NO")
}
