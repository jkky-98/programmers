def solution(n, numlist):
    list_t = []
    for i in numlist:
        if i % n == 0:
            list_t.append(i)
        pass
    return list_t