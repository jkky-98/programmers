def solution(s1, s2):
    a = 0
    for i in s1:
        for j in s2:
            if i == j:
                a += 1
                break
    return a