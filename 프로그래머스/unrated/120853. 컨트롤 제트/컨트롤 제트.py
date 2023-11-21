def solution(s):
    s = s.split(' ')
    for index, i in enumerate(s):
        tape = s[index-1]
        if i == 'Z':
            s[index] = -int(tape)
        else:
            s[index] = int(i)
    answer = sum(s)
    return answer