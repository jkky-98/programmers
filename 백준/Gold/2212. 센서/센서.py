from sys import stdin

n_sensor = int(stdin.readline())
n_house = int(stdin.readline())

sensor_lst = list(map(int, stdin.readline().split()))
# 중복제거
sensor_lst = list(set(sensor_lst))
# 정렬
sensor_lst.sort()

dist_lst = []
for idx, i in enumerate(sensor_lst):
    if idx + 1 < len(sensor_lst):
        dist = sensor_lst[idx + 1] - i
        dist_lst.append(dist)

for i in range(n_house - 1):
    try:
        dist_lst.remove(max(dist_lst))
    except:
        pass


print(sum(dist_lst))
