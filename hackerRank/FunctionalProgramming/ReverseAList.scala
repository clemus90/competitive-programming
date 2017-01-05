def f(arr:List[Int]):List[Int] = arr.foldRight(List.empty[Int])((x, acum) => acum :+ x)
