#!/bin/python3

import os
import sys

#
# Complete the truckTour function below.
#
def truckTour(petrolpumps):
    total_petrol = 0
    start = 0
    
    for i, (petrol, distance) in enumerate(petrolpumps):
        if total_petrol > 0:
            total_petrol += petrol -distance
        else:
            total_petrol = petrol -distance
            start = i
            
    return start

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    petrolpumps = []

    for _ in range(n):
        petrolpumps.append(list(map(int, input().rstrip().split())))

    result = truckTour(petrolpumps)

    fptr.write(str(result) + '\n')

    fptr.close()

