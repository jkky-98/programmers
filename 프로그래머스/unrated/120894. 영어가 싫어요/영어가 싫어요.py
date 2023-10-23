def solution(numbers):
    # numbers에 속하는 문자의 길이는 3, 4, 5이다.
    n_list = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    real = []
    while len(numbers) != 0:
        for i in range(3):
            if numbers[:i+3] in n_list:
                real.append(numbers[:i+3])
                numbers = numbers.replace(numbers[:i+3],'',1)
                break
    answer = []
    for i in real:
        answer.append(str(n_list.index(i)))
    answer = ''.join(answer)
    return int(answer)