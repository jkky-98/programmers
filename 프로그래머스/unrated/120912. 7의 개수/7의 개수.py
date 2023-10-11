def solution(array):
    list_str = []
    list_ans = []
    for i in array:
        list_str.append(str(i))
    for i in list_str:
        for j in list(i):
            list_ans.append(j)
            
    answer = list_ans.count('7')
    return answer