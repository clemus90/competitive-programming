#Review documentation for: Grundy numbers, impartial games, nim game
#https://www.topcoder.com/community/data-science/data-science-tutorials/algorithm-games/
#https://www.hackerrank.com/topics/game-theory-and-grundy-numbers

def build_grundy_numbers(n, divisors, mem_grundy):
    if n in mem_grundy:
        return mem_grundy[n]
    set_g = set()
    for x in divisors:
        if n % x == 0:
            set_g.add(build_grundy_numbers(n // x, divisors, mem_grundy))
    g = 0
    while(g in set_g):
        g+= 1
    mem_grundy[n] = g
    return g

n, m = list(map(int, input().split()))
cuts = list(map(int, input().split()))

mem = {}
print("First" if build_grundy_numbers(n, cuts, mem) != 0 else "Second")
