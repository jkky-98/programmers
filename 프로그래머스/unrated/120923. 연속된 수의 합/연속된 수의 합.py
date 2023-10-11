def solution(num, total):
    list_t = [0] * num
    if num % 2 == 1:
        cent = int(total / num)
        cent_ind = num // 2
        list_t[cent_ind] = cent
        
        for i in range(num // 2):
            list_t[cent_ind - (i+1)] = cent - (i+1)
            list_t[cent_ind + (i+1)] = cent + (i+1)
        
    elif num % 2 == 0 :
        left = total // num
        right = total // num + 1
        left_ind = int(num / 2 - 1)
        right_ind = int(num / 2)


        list_t[left_ind] = left
        list_t[right_ind] = right
        
        for i in range(int(num / 2 - 1)):
    
            list_t[left_ind - (i+1)] = left - (i+1)
            list_t[right_ind + (i+1)] = right + (i+1)
            
    return list_t

