def check(i):
    try:
        can_int = int(i)
        return True
    except:
        return False

def solution(my_string):
    list_tmp = []
    count = 0
    last = len(my_string) - 1

    for index, i in enumerate(my_string):
        if check(i):
            list_tmp.append(i)
        else:
            if len(list_tmp) >= 1:
                count += int(''.join(list_tmp))
                list_tmp.clear()
            else:
                pass
    if list_tmp:
        count += int(''.join(list_tmp))
    return count