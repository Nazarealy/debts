len_min = float('inf')
len_max = float('-inf')
words = []
N = 0
search = dict()
res = 0


with open("wchain.in", "r") as f:
    N = int(f.readline())
    words = [[] for i in range(55)]

    for i in range(N):
        s = f.readline()
        words[len(s)].append(s)
        len_min = min(len_min, len(s))
        len_max = max(len_max, len(s))


for i in range(len_min, len_max + 1):
    if len(words[i-1]) == 0:
        for word in words[i]:
            search[word] = 1
        continue


    for word in words[i]:
        curr_res = 1
        for q in range(i + 1):
            new_word = word[:q] + word[q+1:]
            if new_word in search:
                curr_res = max(curr_res, search[new_word] + 1)


            if (curr_res == i - len_min + 1):
                break


        search[word] = curr_res
        res = max(res, curr_res)


with open("wchain.out", "w") as f:
    f.write(str(res + 1))
