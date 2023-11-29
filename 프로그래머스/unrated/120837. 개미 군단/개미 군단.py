def solution(hp):
    general = hp // 5
    n_1 = hp % 5
    
    sol = n_1 // 3
    n_2 = n_1 % 3
    
    il = n_2
    
    total = general + sol + il
    return total