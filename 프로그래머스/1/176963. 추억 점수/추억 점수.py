def solution(name, yearning, photo):
    dict_name = {n : score for n, score in zip(name, yearning)}
    ans = []
    for i in photo:
        tmp = 0
        for j in i:
            try:
                tmp += dict_name[j]
            except:
                pass
        ans.append(tmp)
        
    return ans