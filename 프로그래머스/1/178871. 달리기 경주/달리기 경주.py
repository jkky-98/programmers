def solution(players, callings):
    dict_p = {player : int(idx) for idx, player in enumerate(players)}
    
    for i in callings:
        rank = dict_p[i] # 이름 불린 선수의 랭크
        front_p = players[rank-1] # 앞 선수 이름
        hold_p = players[rank] # 이름 불린 선수 이름
        rank_f = dict_p[front_p] # 앞 선수 랭크
        
        # 기존 자료구조 수정
        # 딕셔너리(플레이어 이름 기준)
        dict_p[i] -= 1
        dict_p[front_p] += 1
        
        # 리스트(랭크 기준)
        players[rank_f] = hold_p
        players[rank] = front_p
        
        
    return players