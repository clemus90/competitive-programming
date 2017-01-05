import scala.collection.mutable.Queue

object Solution extends App{
  val in = io.Source.stdin.getLines()
  val nodes = in.next.toInt
  val tc = new TreeConstructor(new Tree(1, None, None))
  (1 to nodes).foreach(_ => {
      val node = in.next.split(" ").map(_.toInt)
      tc.addChildren(node(0), node(1))
  })
  val t = tc.root
  val swaps = in.next.toInt
  (1 to swaps).foreach(_ => {
    val level = in.next.toInt
    t.swapNLevelsDown(level, 1)
    println(t.inorder().mkString(" "))
  })

}

class Tree(val root: Int, var left: Option[Tree], var right: Option[Tree]){
  def swap(): Unit  = {
    val temp = this.left
    this.left = this.right
    this.right = temp
  }

  def swapNLevelsDown(n: Int, currLevel: Int): Unit = {
    if(currLevel % n == 0) this.swap
    for{toSwap <- this.left} toSwap.swapNLevelsDown(n, currLevel + 1)
    for{toSwap <- this.right} toSwap.swapNLevelsDown(n, currLevel + 1)
  }

  def inorder(): List[Int] = {
    val leftRec: List[Int] = if(this.left == None){
      Nil
    }else{
      this.left.get.inorder()
    }
    val rightRec: List[Int] = if(this.right == None){
      Nil
    }else{
      this.right.get.inorder()
    }
    (leftRec :+ this.root) ++ rightRec
  }
}

class TreeConstructor(val root: Tree){
  val insertionQueue = Queue(root)
  def addChildren(l: Int, r: Int) = {
    val nextParent = insertionQueue.dequeue()
    nextParent.left = if(l == -1) None else Some(new Tree(l, None, None))
    nextParent.right = if(r == -1) None else Some(new Tree(r, None, None))
    for {toAdd <- nextParent.left} insertionQueue.enqueue(toAdd)
    for {toAdd <- nextParent.right} insertionQueue.enqueue(toAdd)
  }
}
