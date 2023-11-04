def solution(board):
    count = 0
    for idx1, i in enumerate(board):
        for idx2, j in enumerate(i):
            if j == 1:
                try:
                    if board[idx1-1][idx2-1] != 1 and idx1-1 >= 0 and idx2-1 >= 0:
                        board[idx1-1][idx2-1] -= 5
                except:
                    pass 
                try:
                    if board[idx1-1][idx2] != 1 and idx1-1 >= 0 and idx2 >= 0:
                        board[idx1-1][idx2] -= 5
                except:
                    pass
                try:
                    if board[idx1-1][idx2+1] != 1 and idx1-1 >= 0 and idx2+1 >= 0:
                        board[idx1-1][idx2+1] -= 5
                except:
                    pass
                try:
                    if board[idx1][idx2-1] != 1 and idx1 >= 0 and idx2-1 >= 0:
                        board[idx1][idx2-1] -= 5
                except:
                    pass
                try:
                    if board[idx1][idx2+1] != 1 and idx1 >= 0 and idx2+1 >= 0:
                        board[idx1][idx2+1] -= 5
                except:
                    pass
                try:
                    if board[idx1+1][idx2-1] != 1 and idx1+1 >= 0 and idx2-1 >= 0:
                        board[idx1+1][idx2-1] -= 5
                except:
                    pass
                try:
                    if board[idx1+1][idx2] != 1 and idx1+1 >= 0 and idx2 >= 0:
                        board[idx1+1][idx2] -= 5
                except:
                    pass
                try:
                    if board[idx1+1][idx2+1] != 1 and idx1+1 >= 0 and idx2+1 >= 0:
                        board[idx1+1][idx2+1] -= 5
                except:
                    pass 
    for i in board:
        for j in i:
            if j == 0:
                count += 1
                    
                
    
    return count
