import scala.annotation.tailrec

object NQueens extends App {

    case class Vec(x: Int, y: Int){
        def +(other:Vec) = {
            Vec(x + other.x, y + other.y)
        }
    }

    case class Board(arr: Array[Boolean], n: Int){

        def getIfValid(v:Vec) = {
            val posiblePos = v.y * n + v.x
            if(v.x >= 0 && v.y >= 0 && v.x < n && v.y < n) Some(arr(posiblePos))
            else None
        }

        def isAttacked(v:Vec) = {
            

            @tailrec
            def checkAttackInDirection(pos: Vec,  dir: Vec): Boolean = {
                
                val content = getIfValid(pos)
                if(content.isEmpty) false
                else {
                    if(content.get) true
                    else checkAttackInDirection(pos + dir, dir)
                }
            }

            var attacked = false
            for(x <- (-1 to 1);
                y <- (-1 to 1)){
                if(!attacked && (x != 0 || y != 0)) attacked = checkAttackInDirection(v + Vec(x,y), Vec(x,y))
            }
            attacked
        }

        override def toString = {
            val buf = new StringBuilder
            for(row <- 0 until n){
                buf ++= arr.slice(row * n, (row + 1) * n).map(x => if(x) 1 else 0).mkString("" , " " , "\n")
            }
            buf.toString
        }

        def set(v: Vec, newVal: Boolean) = {
            if(!getIfValid(v).isEmpty)arr(v.y*n + v.x) = newVal
        }

    }
    
    object Board {
        def apply(n: Int) = new Board(Array.fill[Boolean](n*n)(false), n)

        def copy(board: Board) = {
            val newBoard = Array.ofDim[Boolean](board.arr.size)
            Array.copy(board.arr, 0, newBoard, 0, board.arr.size)
            new Board(newBoard, board.n)
        }
    }

    def nQueens(b:Board, remaining: Int):Option[Board] = {
        
        if (remaining == 0) Some(b)
        else{
            var y = 0
            var solutionFound = false
            var solution: Option[Board] = None
            while(!solutionFound && (y < b.n)){
                var x = 0
                
                while(!solutionFound && (x < b.n)){
                    
                    
                    if(!(b.getIfValid(Vec(x,y)).get) && !b.isAttacked(Vec(x,y))){
                        val copy = Board.copy(b)
                        copy.set(Vec(x,y), true)
                        
                        val rec = nQueens(copy, remaining-1)
                        if(!rec.isEmpty){
                            solutionFound = true
                            solution = rec
                        }
                    }
                    x += 1
                }
                y += 1
            }
            solution
        }
    }

    val n = io.Source.stdin.getLines().next.toInt
    val result = nQueens(Board(n), n)
    if(result.isEmpty) println("NO")
    else{
        println("YES")
        println(result.get)
    }

}