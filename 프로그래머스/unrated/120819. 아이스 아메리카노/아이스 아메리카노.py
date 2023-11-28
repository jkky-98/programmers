def solution(money):
    answer = []
    can_ame = money // 5500
    zandon = money - can_ame * 5500
    
    answer.append(can_ame)
    answer.append(zandon)
    return answer