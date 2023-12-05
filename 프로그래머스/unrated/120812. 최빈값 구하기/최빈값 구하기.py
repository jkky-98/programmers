def solution(array):
    dict_ans = {}
    for i in array:
        if i not in dict_ans:
            dict_ans[i] = 1
        else:
            dict_ans[i] += 1
    
    max_a = max(dict_ans.values())
    find_max = [x for x in dict_ans.values() if x==max_a]
    
    if len(find_max) > 1:
        return -1
    
    for key, value in dict_ans.items():
        if value == find_max[0]:
            return key