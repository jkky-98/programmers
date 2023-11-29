def solution(age):
    p962 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']
    age = list(str(age))
    list_tmp = []
    for i in age:
        p = p962[int(i)]
        list_tmp.append(p)
        
    
    answer = ''.join(list_tmp)
    return answer