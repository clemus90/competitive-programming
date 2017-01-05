def f(num:Int,arr:List[Int]):List[Int] = arr.flatMap(x => (1 to num).map(n => x).toList)

f(3, List(1,2,3,4)).foreach(x => println(x))
