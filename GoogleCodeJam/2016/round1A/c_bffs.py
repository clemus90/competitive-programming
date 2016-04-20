def graph_components(graph):
    components = []
    missing = graph[:]
    while missing:
        seed = missing.pop(0)
        comp = [seed]
        fill_comp(seed, comp, missing)
        components.append(comp)
    return components

def fill_comp(seed, comp, missing):
    fill_outputs(seed, comp, missing)
    fill_inputs(seed,comp,missing)

def fill_outputs(seed, comp, missing):
    index = index_in_comp(seed['bff'],missing)
    if index != None:
        bff = missing.pop(index)
        comp.append(bff)
        fill_outputs(bff, comp, missing)
        fill_inputs(bff, comp, missing)

def fill_inputs(seed, comp, missing):
    for x in seed['is_bff']:
        index = index_in_comp(x, missing)
        if index != None:
            incidence = missing.pop(index)
            comp.append(incidence)
            fill_outputs(incidence, comp, missing)
            fill_inputs(incidence, comp, missing)

def index_in_comp(node, comp):
    for i, x in enumerate(comp):
        if x['label'] == node['label']:
            return i
    return None

def cycle_length(comp):
    path = []
    beg = comp[0]
    while beg['label'] not in path:
        path.append(beg['label'])
        beg = beg['bff']
    index = path.index(beg['label'])
    size = len(path)-index
    if size > 2:
        return size, None, None
    else:
        return size, beg, beg['bff']

def max_branch(node, ex=None):
    queue = [x for x in node['is_bff'] if ex == None or x['label'] != ex['label']]
    maximum = 1
    for x in queue:
        val = max_branch(x) + 1
        if val > maximum: maximum = val
    return maximum

import sys

sys.setrecursionlimit(2000)

t = int(raw_input())
for case in xrange(1, t+1):
    students = int(raw_input())
    graph = [{'label':i+1, 'is_bff':[], 'bff':x} for i, x in enumerate(map(int, raw_input().split()))]

    for child in graph:
        child['bff'] = graph[child['bff']-1]
        child['bff']['is_bff'].append(child)

    components = graph_components(graph)
    lengths = [cycle_length(x) for x in components]

    maximum = 0
    length2total = 0
    for l, origin, end in lengths:
        if l == 2:
            length2total += max_branch(origin,end) + max_branch(end,origin)
        else:
            if maximum < l: maximum = l

    if length2total > maximum: maximum = length2total

    print "Case #{}: {}".format(case, maximum)
