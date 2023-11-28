import math

def solution(price):
    if price >= 500000:
        answer = price * 0.8
        return math.trunc(answer)
    
    if price >= 300000:
        answer = price * 0.9
        return math.trunc(answer)
    
    if price >= 100000:
        answer = price * 0.95
        return math.trunc(answer)
    else:
        return price
