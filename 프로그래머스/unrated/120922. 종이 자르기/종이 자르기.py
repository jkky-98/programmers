def solution(M, N):
    if M == 1 and N == 1:
        return 0
    
    big = max(M,N)
    small = min(M,N)
    
    answer = (small-1)*(big)+(big-1)
    
    return answer