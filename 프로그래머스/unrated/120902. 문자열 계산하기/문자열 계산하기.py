from queue import Queue
cal_que = Queue()
num_que = Queue()

def solution(my_string):
    my_string = my_string.split(' ') #공백을 기준으로 리스트화
    for i in my_string:
        if (i=='+') or (i=='-'):
            cal_que.put(i)
        else:
            num_que.put(i)
    
    #계산
    count = 0
    while num_que.empty() == False and num_que.empty() == False:
        if count == 0:
            num = num_que.get()
            count += int(num)
        else:
            cal = cal_que.get()
            num = num_que.get()
            if cal == '+':
                count += int(num)
            elif cal == '-':
                count -= int(num)
            
    
    return count