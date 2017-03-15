object MelodiousPassword extends App{
    val vowels = Vector("a", "e", "i", "o", "u")
    val consonants = ('b' to 'z').filterNot(x => {
        vowels.contains(""+x) || x == 'y'
    }).map("" + _).toVector
                            //  first-constant , first-vowel
    def passwords(size: Int): (Vector[String], Vector[String]) = size match {
        case 1 => (consonants, vowels)
        case n => val acum = passwords(n-1)
            (consonants.flatMap(prefix => acum._2.map(suffix => prefix + suffix)),
                vowels.flatMap(prefix => acum._1.map(suffix => prefix + suffix)))
    }

    val in = io.Source.stdin.getLines()
    val n = in.next.toInt
    val (cStarting, vStarting) = passwords(n)
    for(x <- cStarting) println(x)
    for(x <- vStarting) println(x)

}