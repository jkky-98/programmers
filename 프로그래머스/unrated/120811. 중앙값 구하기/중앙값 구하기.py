import math

def solution(array):
    array.sort()
    center = math.ceil(len(array)/2)
    answer = array[center-1]
    return answer