def solution(record):
    record_lst = [x.split(" ") for x in record]
    db = dict()
    for i in record_lst:
        
        if i[0] == "Leave":
            continue
        
        db[i[1]] = i[2]
    
    result = []
    for i in record_lst:
        if i[0] == "Enter":
            result.append(db[i[1]] + "님이 들어왔습니다.")
        elif i[0] == "Leave":
            result.append(db[i[1]] + "님이 나갔습니다.")
    return result
        