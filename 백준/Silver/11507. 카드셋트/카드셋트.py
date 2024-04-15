deck = {'P': 13, 'K': 13, 'H': 13, 'T': 13}
data = str(input())
have = []
dont = False
for i in range(0, len(data), 3):
    start = i
    start_num = i + 1
    end_num = i + 2
    key = data[start]
    value = data[start_num:end_num + 1]
    card = data[start:end_num + 1]

    deck[key] -= 1
    if card in have:
        print("GRESKA")
        dont = True
    else:
        have.append(card)
if not dont:
    for i in deck.values():
        print(i, end=" ")