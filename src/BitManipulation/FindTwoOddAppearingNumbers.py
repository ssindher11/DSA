def find(arr, n):
    xor = 0
    r1 = 0
    r2 = 0
    for i in range(n):
        xor ^= arr[i]
    
    sn = xor & -xor
    for i in range(n):
        if ((sn & arr[i]) != 0):
            r1 ^= arr[i]
        else:
            r2 ^= arr[i]
    print(r1, ' ', r2)


if __name__ == "__main__":
    li = [3, 4, 3, 4, 8, 4, 4, 31, 7, 7]
    find(li, len(li))