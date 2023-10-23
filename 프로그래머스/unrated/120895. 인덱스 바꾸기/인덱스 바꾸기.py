def solution(my_string, num1, num2):
    num1_new = my_string[num2]
    num2_new = my_string[num1]
    list_tmp = list(my_string)
    list_tmp[num1] = num1_new
    list_tmp[num2] = num2_new
    ans = ''.join(list_tmp)
    return ans