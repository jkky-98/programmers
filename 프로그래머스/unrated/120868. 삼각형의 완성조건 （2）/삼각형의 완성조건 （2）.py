def solution(sides):
    max_length = sum(sides)
    min_length = max(sides) - min(sides) + 1
    
    count = 0
    for i in range(min_length, max_length):
        count += 1
        
    return count