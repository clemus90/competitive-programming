import scala.annotation.tailrec

object BatmanAndTickTackToe extends App {

  case class Vec(x: Int, y: Int) {
    def posInBoard = {
      (y * 4) + x
    }

    def validPos = {
      this.x >=0 && this.x < 4 && this.y >= 0 && this.y < 4
    }

    def +(other: Vec) = {
      Vec(this.x + other.x, this.y + other.y)
    }
  }

  object Vec {
    def vectorFromPos(pos: Int) = Vec(pos%4, pos/4)
  }

  def countOcurrenceOnDirection(board: Vector[Char], initialPos: Vec, direction: Vec, player: Char): Int = {
    @tailrec
    def rec(pos: Vec, acum: Int):Int = {
      if(pos.validPos && (board(pos.posInBoard) == player)) rec(pos + direction, acum + 1)
      else acum
    }
    rec(initialPos + direction, 0)
  }

  def calcNextPlayer(v: Vector[Char]): Char = {
    val countO = v.foldLeft(0)((count, x) => if(x == 'o') count+1 else count)
    val countX = v.foldLeft(0)((count, x) => if(x == 'x') count+1 else count)
    if(countX <= countO)'x'
    else 'o'
  }

  val in = io.Source.stdin.getLines()
  val tc = in.next.toInt
  for(_ <- 1 to tc){
    var board = Vector.empty[Char]
    for(_ <- 1 to 4){
      board = board ++ in.next.toVector
    }
    val nextPlayer = calcNextPlayer(board)
    val winningGame = (0 until board.size).exists(i => {
      if(board(i) == '.'){
        val countOc = countOcurrenceOnDirection(board, Vec.vectorFromPos(i), _:Vec, nextPlayer)
        if((countOc(Vec(-1, 0)) + countOc(Vec(1, 0))) >= 2)true
        //vertical
        else if((countOc(Vec(0,-1)) + countOc(Vec(0,1))) >= 2)true
        //diagonal decreasing
        else if((countOc(Vec(-1,-1)) + countOc(Vec(1,1))) >= 2)true
        //diagonal increasing
        else if((countOc(Vec(-1,1)) + countOc(Vec(1,-1))) >= 2) true
        else false
      }else false
    })
    println(if(winningGame)"YES" else "NO" )
  }
}
