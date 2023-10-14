from itertools import product

def solution(users, emoticons):
    rate = [10, 20, 30, 40] # 가능한 할인율
    
    repeat_n = len(emoticons)
    
    rate_lst = list(product(rate, repeat = repeat_n)) # 할인율 조합 리스트 만들기
    
    case_lst = [] # rate별 케이스 모을 곳
    for rate in rate_lst:
        emo_plus = 0
        emo_purchase = 0
            
        for user in users:
            
            customer_rate = user[0]
            customer_price = user[1]
            
            # 할인율에 따른 emoticon 가격 리스트
            price_lst = [int(emoticons[i] * (100 - rate[i]) / 100) 
                         for i in range(len(rate))]
            purchase = []
            
            
            for rate_ in rate: # 고객이 살 것에 대한 리스트 0과 1로 나타내기
                if rate_ >= customer_rate: # 고객이 구매할 경우
                    purchase.append(1)
                else: # 고객이 구매 안할 경우
                    purchase.append(0)
            
            # 실제로 고객이 구매할 물건별 결제 가격
            total_purchase = [purchase[i] * price_lst[i] 
                              for i in range(len(price_lst))]
            
            cond = sum(total_purchase) # rate경우의 수에 따른 고객의 전체 구매 가격 
    
            if cond >= customer_price: # 가격을 기준으로 카운트
                emo_plus += 1
            else:
                emo_purchase += cond
        
        case_lst.append([emo_plus, emo_purchase])
        
    case_lst.sort(key= lambda x : (x[0], x[1]), reverse=True)
    return case_lst[0]

                
                    
                
                
                
                
                
            