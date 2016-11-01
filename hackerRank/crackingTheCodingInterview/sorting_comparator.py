from functools import cmp_to_key
class Player:
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def __repr__(self):
        return "{0} {1}".format(self.name, self.score)

    def comparator(a, b):
      calc = b.score - a.score
      if(calc == 0):
        if a.name < b.name:
          return -1
        elif a.name == b.name:
          return 0
        else:
          return 1
      return calc

n = int(input())
data = []
for i in range(n):
    name, score = input().split()
    score = int(score)
    player = Player(name, score)
    data.append(player)
    
data = sorted(data, key=cmp_to_key(Player.comparator))
for i in data:
    print(i.name, i.score)