def solution(n):
    remain = n
    for i in range(1,n+1):
        remain = remain / i
        if remain <= i:
            return i