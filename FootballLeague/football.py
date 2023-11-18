n = int(input())

L = input().split()

scoretable = dict()

for team in L:
    # matches, goals for, goals against, goals diff, points
    scoretable[team] = [dict(), 0, 0, 0, 0]
    

m = int(input())
flag = False

for _ in range(m):
    t1, t2, s1, s2 = input().split()
    s1 = int(s1) 
    s2 = int(s2)
    
    if (t1 == t2):
        flag = not flag
        print("Invalid Inout")
        break
    
    matches = scoretable[t1][0]
    
   
    if (t2 not in matches):
        matches[t2] = 1
    else:
        if (matches[t2] == 2):
            flag = not flag
            break
        matches[t2] += 1        
        
    scoretable[t1][1] += s1
    scoretable[t1][2] += s2
    scoretable[t1][3] += s1 - s2
    
    if (s1 > s2):
        scoretable[t1][4] +=2
    elif (s1 == s2):
        scoretable[t1][4] += 1
        
    matches = scoretable[t2][0]

    if (t1 not in matches):
        matches[t1] = 1
    else:
        if (matches[t1] == 2):
            flag = not flag
            break
        matches[t1] += 1   
        
    scoretable[t2][1] += s1
    scoretable[t2][2] += s2
    scoretable[t2][3] += s1 - s2
    
    if (s1 > s2):
        scoretable[t2][4] +=2
    elif (s1 == s2):
        scoretable[t2][4] += 1

rankings = []
 
for key in scoretable:
    points = scoretable[key][-1]
    rankings.insert(points, key)
  
if (flag):
    print("Invalid Input")
else:
    print(rankings[::-1])