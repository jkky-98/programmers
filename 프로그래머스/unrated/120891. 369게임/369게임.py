def solution(order):
    rull = ['3','6','9']
    order = list(str(order))
    count = 0
    for i in order:
        if i in rull:
            count += 1
    return count