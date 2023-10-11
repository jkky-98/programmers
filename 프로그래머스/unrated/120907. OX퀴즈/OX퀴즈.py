def check(epres):
    epres = epres.split(' = ')
    cond = epres[0]
    ans = epres[1]
    
    if ' + ' in cond:
        cond = cond.split(' + ')
        cond = list(map(int, cond))
        pred = sum(cond)
        if pred == int(ans):
            return "O"
        else:
            return "X"
    elif ' - ' in cond:
        cond = cond.split(' - ')
        cond = list(map(int, cond))
        cond[1] = -cond[1]
        pred = sum(cond)
        if pred == int(ans):
            return "O"
        else:
            return "X"
        

def solution(quiz):
    answer = []
    for i in quiz:
        answer.append(check(i))
        
    
    return answer