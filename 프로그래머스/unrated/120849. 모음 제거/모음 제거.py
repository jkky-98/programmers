def solution(my_string):
    vowels = ['a', 'e', 'i', 'o', 'u']
    list_tmp = []
    for i in my_string:
        if i not in vowels:
            list_tmp.append(i)
    answer = ''.join(list_tmp)
    return answer