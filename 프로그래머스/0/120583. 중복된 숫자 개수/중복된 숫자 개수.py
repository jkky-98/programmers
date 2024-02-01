def solution(array, n):
    tmp = 0
    for i in array:
        if n == i :
            tmp += 1
    return tmp