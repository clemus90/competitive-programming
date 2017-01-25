object BatmanAndTickTackToe extends App {

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
        //horizontal
        if((i-1)%4 > 0 && board(i-1) == nextPlayer &&
          (i+1)%4 < 4 && board(i+1) == nextPlayer) true
        //vertical
        else if(i-4) > 0 && board(i-4) == nextPlayer &&
          (i+4)<board.size &&  board(i+4) true
        //diagonal decreasing
        else if(i-)
      }else False
    })
  }
}
