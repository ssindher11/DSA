nd = input().split()
n = int(nd[0])
d = int(nd[1])

A = list(map(int, input().rstrip().split()))
for value in (A[d:] + A[0:d]): 
    A.append(value)
del A[:n]
return A
