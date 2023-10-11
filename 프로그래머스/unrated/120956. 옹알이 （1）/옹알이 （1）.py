def solution(babbling): # replace메서드활용
    count = 0
    baby = ["aya", "ye", "woo", "ma" ]
    for i in babbling:
        for j in baby:
            i = i.replace(j," ",-1)
        i = i.strip()
        if i == '':
            count += 1   
    return count