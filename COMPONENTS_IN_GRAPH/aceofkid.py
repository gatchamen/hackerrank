#!/bin/python3

import os
import sys
import queue
#
# Complete the componentsInGraph function below.
#
def combineEdge (edges, item):
    mergeEdges = []
    removeEdges = []
    isItemMerged = False
    for edge in edges:
        if item & edge:
            removeEdges.append(edge)
            mergeEdges.append(item | edge)
            isItemMerged = True

    if isItemMerged == False:
        edges.append(item)
    else:
        for edge in removeEdges:
            edges.remove(edge)

    return mergeEdges

def componentsInGraph(gb):
    result = []
    graphQ = queue.Queue()

    for item in gb:
        graphQ.put(item)

    while not graphQ.empty():
        itemSet = set(graphQ.get())
        if len(result) == 0:
            result.append(itemSet)
        else:
            mergeEdges = combineEdge(result, itemSet)
            if len(mergeEdges) is not 0:
                for edge in mergeEdges:
                    graphQ.put(list(edge))

    minVertex = min(result, key=lambda x: len(x))
    maxVertex = max(result, key=lambda x: len(x))

    print("result: %d %d" % (len(minVertex), len(maxVertex)))

    return (len(minVertex), len(maxVertex))

if __name__ == '__main__':
    inFile = open('testcase19.txt','r')
    readLines = inFile.readlines()
    inFile.close()

    n = int(readLines[0])

    gb = []

    for line in readLines[1:]:
        gb.append(list(map(int, line.rstrip().split())))

    result = componentsInGraph(gb)

    print(result)


'''
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    gb = []

    for _ in range(n):
        gb.append(list(map(int, input().rstrip().split())))

    result = componentsInGraph(gb)

    fptr.write(' '.join(map(str, SPACE)))
    fptr.write('\n')

    fptr.close()
'''
