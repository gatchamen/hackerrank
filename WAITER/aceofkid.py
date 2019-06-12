#!/bin/python3

import os
import sys
#
# Complete the waiter function below.
#
def generator_primes():
    for primeTest in range(2, 99999999):
        isPrime = True
        for num in range(2, primeTest):
            if primeTest % num == 0:
                isPrime = False

        if isPrime:
            yield primeTest

def waiter(number, q):
    listA = number[:]
    listB = []
    result = []
    primes = generator_primes()
    for _ in range(q):
        tempA = []
        tempB = []
        divider = next(primes)
        for num in listA[::-1]:
            if num % divider == 0:
                tempB.append(num)
            else:
                tempA.append(num)
        listA = tempA
        if len(tempB) != 0:
            listB.append(tempB[::-1])
    result.extend([x for row in listB for x in row])
    result.extend(listA[::-1])

    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nq = input().split()

    n = int(nq[0])

    q = int(nq[1])

    number = list(map(int, input().rstrip().split()))

    result = waiter(number, q)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
