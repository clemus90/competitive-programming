object SortTheSubstring extends App {

    def sort(s: String) = s.toList.sortWith(_ > _).mkString

    val in = io.Source.stdin.getLines()
    val t = in.next.toInt
    for (_ <- 1 to t){
        val test = in.next.split(" ")
        val s = test(0)
        val beg = test(1).toInt
        val end = test(2).toInt
        println(s"${s.substring(0,beg)}${sort(s.substring(beg,end+1))}${s.substring(end+1)}")
    }
}
