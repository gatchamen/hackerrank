#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):
    stack = list()
    for c in s:
        if c in ["{", "[", "("]:
            stack.append(c)
        else:
            if not stack:
                return "NO"

            d = stack.pop()
            if c == "}" and d != "{":
                return "NO"
            
            if c == "]" and d != "[":
                return "NO"

            if c == ")" and d != "(":                
                return "NO"
        
    if not stack:
        return "YES"
    else:
        return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + ' ' + s + '\n')

    fptr.close()

