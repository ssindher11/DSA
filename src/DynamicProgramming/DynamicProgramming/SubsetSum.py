# Recursive Approach
# Time Complexity : O(2^n)
def count_subsets_rec(arr, n, sum):
    if n == 0:
        return 1 if sum == 0 else 0
    return count_subsets_rec(arr, n - 1, sum) + count_subsets_rec(arr, n - 1, sum - arr[n - 1])


# Dynamic Programming
# Time Complexity : O(n * sum)
# Auxiliary space : O(n * sum)
def count_subsets(arr, n, sum):
    dp = [[0 for i in range(sum + 1)] for j in range(n + 1)]

    for i in range(n + 1):
        dp[i][0] = 1

    for i in range(1, n + 1):
        for j in range(1, sum + 1):
            if j >= arr[i - 1]:
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[n][sum]


if __name__ == "__main__":
    arr = [10, 20, 15, 5, 5]
    sm = 25
    print(count_subsets_rec(arr, len(arr), sm))
    print(count_subsets(arr, len(arr), sm))