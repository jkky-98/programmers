def solution(array, height):
    tmp = 0
    for i in array:
        if height < i:
            tmp += 1
    return tmp 