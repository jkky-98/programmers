def solution(num, k):
    n_str = list(str(num))
    index = 0
    for i in n_str:
        if i != str(k):
            index = index + 1
        else:
            break
            
    if index+1 > len(n_str):
        ans = -1
        return ans
    return index + 1