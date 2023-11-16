cols = int(input())
galaxy = []

for _ in range(3):
    galaxy.append(input())

res = ""
vowels = {
    "A": [".**","**.",".**"],
    "E": ["***","***","***"],
    "I": ["*.*","***","*.*"],   
    "O": ["***","*.*","***"],
    "U": ["***","..*","***"]
}

L = []
for col in range(cols):
    if (galaxy[0][col] == "#"):
        res += "#"        
        L = []
        continue
    
    pat = galaxy[0][col] + galaxy[1][col] + galaxy[2][col]
    L.append(pat)
    
    if (len(L) == 3):
        for k,v in vowels.items():
            if (L == v):
                res += k
                L = []
                break
    
print(res)