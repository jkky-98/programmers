import math
import numbers

def solution(n):
    answer = 2
    isint = int(math.sqrt(n)) == math.sqrt(n)
    if isint:
        answer = 1
    
    return answer