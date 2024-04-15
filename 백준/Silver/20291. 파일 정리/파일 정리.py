from sys import stdin

n = int(stdin.readline())

hash_ = {}

for i in range(n):
    item = stdin.readline().rstrip()
    item = item.split(".")
    if item[1] not in hash_.keys():
        hash_[item[1]] = 1
    else:
        hash_[item[1]] += 1
final = []
for key, value in hash_.items():
    final.append((key, value))

final = sorted(final, key= lambda x : x[0])

for i in final:
    key, value = i
    print("{} {}".format(key, value))