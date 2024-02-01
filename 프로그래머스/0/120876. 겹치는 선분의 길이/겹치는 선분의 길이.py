def solution(lines):
    l1 = list(range(lines[0][0],lines[0][1]+1))
    l2 = list(range(lines[1][0],lines[1][1]+1))
    l3 = list(range(lines[2][0],lines[2][1]+1))
    #첫번째 선분과 두번째 선분 겹치는지 여부 및 겹치는 길이
    
    #누가 더 긴 선분인지 파악 및 겹치는 길이 계산
    def length_overlap(l1,l2):
        list_tmp = []
        if len(l1) >= len(l2):
            for i in l2:
                if i in l1:
                    list_tmp.append(i)
        else:
            for i in l1:
                if i in l2:
                    list_tmp.append(i)
        if len(list_tmp) <= 1:
            list_tmp = []
        return list_tmp
    
    l1_l2 = length_overlap(l1,l2)
    l1_l3 = length_overlap(l1,l3)
    l2_l3 = length_overlap(l2,l3)

    count = 0
    if len(l1_l2) == 0 or len(l1_l3) == 0 or len(l2_l3) == 0:
        for i in [l1_l2, l1_l3, l2_l3]:
            if len(i) != 0:
                count += (max(i) - min(i))
    else:
        overlap = l1_l2 + l2_l3 + l1_l3
        count = max(overlap) - min(overlap)
    
    return count