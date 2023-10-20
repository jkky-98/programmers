def solution(n):
    list_tmp = []
    for i in range(1,n+1):
        if n % i == 0:
            list_tmp.append(n // i)
        
    list_tmp.sort()
    ans = list_tmp
    return ans