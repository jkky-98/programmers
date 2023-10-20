def solution(s):
    dict_check = {}
    for i in s:
        if i in dict_check:
            dict_check[i] += 1
        else:
            dict_check[i] = 1
    
    list_tmp = []
    
    for i in dict_check.keys():
        if dict_check[i] == 1:
            list_tmp.append(i)
            
    list_tmp.sort()
    answer = ''.join(list_tmp)
    return answer