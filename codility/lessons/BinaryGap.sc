import scala.annotation.tailrec

object Solution {
  def solution(n: Int): Int = {
    @tailrec
    def sol(rem: Seq[Char], currMax: Int, currCount: Int): Int = {
      rem match {
        case '1' +: prefix =>
          sol(prefix, currMax max currCount, 0)
        case '0' +: prefix =>
          sol(prefix, currMax, currCount + 1)
        case _ =>
          currMax
      }

    }

    @tailrec
    def initialPos(rem: Seq[Char]): Seq[Char] = {
      rem match {
        case '1' +: prefix =>
          rem
        case '0' +: prefix =>
          initialPos(prefix)
        case _ =>
          "".toSeq
      }
    }

    sol(initialPos(n.toBinaryString.toSeq), 0, 0)
  }
}
//CORRECTNESS: 100%
//TASK SCORE: 100%
println(Solution.solution(1041))
println(Solution.solution(15))
println(Solution.solution(1))
println(Solution.solution(5))
println(Solution.solution(2147483647))
println(Solution.solution(6))
println(Solution.solution(328))
println(Solution.solution(5))
println(Solution.solution(16))
println(Solution.solution(1024))
println(Solution.solution(9))
println(Solution.solution(11))
println(Solution.solution(19))
println(Solution.solution(42))
println(Solution.solution(1162))
println(Solution.solution(5))
println(Solution.solution(51712))
println(Solution.solution(20))
println(Solution.solution(561892))
println(Solution.solution(9))
println(Solution.solution(66561))
println(Solution.solution(6291457))
println(Solution.solution(74901729))
println(Solution.solution(805306373))
println(Solution.solution(1376796946))
println(Solution.solution(1073741825))
println(Solution.solution(1610612737))
