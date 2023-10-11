def solution(str1, str2):
    a = str1.find(str2)
    if a >= 0:
        return 1
    else:
        return 2