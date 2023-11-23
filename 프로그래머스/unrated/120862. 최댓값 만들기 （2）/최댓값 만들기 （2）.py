def solution(numbers):
    arr1 = numbers
    arr1.sort(reverse=True)
    
    front = arr1[0]*arr1[1]
    end = arr1[-1]*arr1[-2]
    
    if front > end:
        answer = front
    elif front < end:
        answer = end
    else:
        answer = front
    return answer