class Node:
    def __init__(self,id):
        self.id = id
        self.arcs = []
    def addConnection(self, dest):
        self.arcs.append(dest)

def addUndirectedArc(graph, u, v):
    graph[u].addConnection(v)
    graph[v].addConnection(u)

def calcDistance(graph, origin, visited, distances):
    toVisit = [(origin, 0)]
    visited.add(origin)
    while(toVisit):
        current, length = toVisit.pop()
        distances[current] = str(length)
        for node_index in graph[current].arcs:
            if not node_index in visited:
                visited.add(node_index)
                toVisit.insert(0,(node_index, length + 6))




queries = int(input())
for q in range(queries):
    nodes, edges = list(map(int,input().split()))
    graph = [Node(i) for i in range(nodes+1)]
    for arc in range(edges):
        u, v = list(map(int,input().split()))
        addUndirectedArc(graph,u,v)
    s = int(input())
    distances = [str(-1)] * (nodes + 1)
    calcDistance(graph, s, set(), distances)
    print(' '.join(distances[1:s]+distances[s+1:]))
