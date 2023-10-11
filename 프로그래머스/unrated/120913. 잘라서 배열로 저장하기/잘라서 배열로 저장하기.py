def solution(my_str, n):
    my_str = list(my_str)
    start = 0
    list_tmp = []
    
    if len(my_str) == 1:
        return my_str
    
    for i in range(n, len(my_str), n):
        list_tmp.append(''.join(my_str[start:i]))
        start = i

    list_tmp.append(''.join(my_str[start:]))
    
    return list_tmp
    