def solution(s):
    # 문자열 형태 해체하기
    lst_s = s[2:-2].split("},{")
    lst_s.sort(key = lambda x : len(x))
    
    lst_s = [x.split(',') for x in lst_s]

    answer = []
    for i in lst_s:
        prev = set(answer)
        if len(i) == 1:
            answer.append(i[0])
        else:
            add_p = set(i) - set(answer)
            answer.append(add_p.pop())

    answer = list(map(int, answer))
    return answer
            
            