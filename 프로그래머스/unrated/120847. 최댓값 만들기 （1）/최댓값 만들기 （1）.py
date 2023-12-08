def solution(numbers):
    top = max(numbers)
    numbers.remove(top)
    top_2 = max(numbers)
    return top * top_2