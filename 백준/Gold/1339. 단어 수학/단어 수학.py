from sys import stdin

from collections import defaultdict
n = int(stdin.readline())

dict_digit = {
}
for i in range(0,8):
    dict_digit[i] = []
str_full = ""
before_change = []
for i in range(n):
    str_data = str(stdin.readline().rstrip())
    before_change.append(str_data)
    str_full = str_full + str_data
    item = list(str_data)
    item.reverse()

    for idx, alpha in enumerate(item):
        dict_digit[idx].append(alpha)

unique_alpha = set(str_full)

power = defaultdict(int)
for i in unique_alpha:
    for key in dict_digit.keys():
        package = dict_digit[key]
        for p in package:
            if i == p:
                power[i] += 10 ** key

power = [(key, value) for key, value in power.items()]
power.sort(key=lambda x:-x[1])

changer = {}
num = 9
for i in power:
    changer[i[0]] = num
    num -= 1

after_change = []
for i in before_change:
    item = i
    for k in i:
        item = item.replace(k, str(changer[k]))
    after_change.append(item)


# stack
final = 0
for i in after_change:
    num = int(i)
    final += num

print(final)

