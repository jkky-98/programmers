def solution(cipher, code):
    list_ans = []
    for i in range(code-1,len(cipher),code):
        list_ans.append(cipher[i])
        answer = ''.join(list_ans)
    return answer