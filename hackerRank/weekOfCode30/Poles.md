# Poles _(HackerRank [Week of Code 30](https://www.hackerrank.com/contests/w30/challenges))_

## Recursion Relationship
To build a best aproach for the `ith` item with `k` stacks, it is needed to explore two cases.

1. What if the stack is created at that position, in which case, the best result is going to be the minimum cost of the `i - 1` item with `k - 1` stacks
2. What if the item in position `i` needs to be added to a previously created queue, in this case the minimization is considered by adding the current item to the best way of adding `k` stacks to every `j` where `j < i`