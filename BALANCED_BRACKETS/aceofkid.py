#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):
    stack = []
    match_bracket = {'}': '{', ']': '[', ')': '('}
    for ch in s:
        if ch in '{[(':
            stack.append(ch)
        else:
            if len(stack) is not 0:
                pre_bracket = stack.pop()
                if match_bracket[ch] is not pre_bracket:
                    return "NO"
            else:
                return "NO"

    if len(stack) is not 0:
        return "NO"

    return "YES"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
