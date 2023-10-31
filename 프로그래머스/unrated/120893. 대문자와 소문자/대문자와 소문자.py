def solution(my_string):
    list_ans = []
    for i in my_string:
        if i.isupper():
            list_ans.append(i.lower())
        else:
            list_ans.append(i.upper())
    final = ''.join(list_ans)
    return final