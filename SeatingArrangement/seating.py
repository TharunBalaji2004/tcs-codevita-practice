from itertools import combinations
import math

def distributions(n, k, L): 
    if (n == 1):
        return L
      
    res = math.ceil(n / k)

    L.append(res)
    return distributions(res, k, L)

def print_combinations(arr, k):
    return list(combinations(arr, k))

n = int(input("Enter value for n: "))
r = int(input("Enter value for r: "))

arr = [i for i in range(1, n + 1)]

L = []
distributions(n, r, L)

print("Resulting distribution:", L)

res = []
for num in L:
    ans = print_combinations(arr, num)
    res.append(ans)

ways = 0
for i in range(len(res[0])):
    for j in range(len(res[1])):
        if len(set(res[0][i]).intersection(set(res[1][j]))) == 0:
            print(f"{res[0][i]} & {res[1][j]}")
            ways += 1
            
print("No of ways:", ways)