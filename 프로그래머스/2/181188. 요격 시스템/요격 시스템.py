def solution(targets):
    targets.sort(key = lambda x : x[1])
    
    # 시작 요격선 설정
    
    abm = -1 # 요격 미사일 위치
    abm_cnt = 0 # 요격 미사일 수
    
    for bomb in targets: 
        if bomb[0] > abm:
            abm_cnt += 1
            abm = bomb[1] - 0.2
    
    return abm_cnt