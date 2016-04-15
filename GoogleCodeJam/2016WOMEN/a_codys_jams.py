t = int(raw_input())

for case in xrange(1, t+1):
  items = int(raw_input())
  labels = [int(x) for x in raw_input().split()]
  labels.sort()

  sales_prices = []

  while(labels):
    first_item = labels[0]
    labels = labels[1:]
    labels.remove((first_item*4)/3)

    sales_prices.append(first_item)

  print "Case #{}: {}".format(case, " ".join(map(str, sales_prices)))