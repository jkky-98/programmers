def solution(common):
    num1 = common[1] - common[0]
    num2 = common[2] - common[1]
    if num1 == num2: # 등차수열
        answer = common.pop() + num1
    else: # 등비수열
        answer = common.pop() * (common[1] / common[0])
        
        
    return answer