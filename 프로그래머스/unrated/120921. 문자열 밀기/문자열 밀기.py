def check(input_, output):
    new_ = ['']*len(input_)
    input_ = list(input_)
    input_without_last = input_[:-1]
    list_range = list(range(1,len(input_)))
    last = input_[len(input_)-1:][0]
    for index, i in zip(list_range, input_without_last):
        new_[index] = i
    new_[0] = last
    new_ = ''.join(new_)
    return new_
    
        

def solution(A, B):
    if A == B:
        return 0
    try_n = len(A)-1
    
    input_ = A
    output_ = B
    
    count = 0
    for i in range(try_n):
        count += 1
        tmp = check(input_, output_)
        if tmp == output_:
            return count
        input_ = tmp
    return -1