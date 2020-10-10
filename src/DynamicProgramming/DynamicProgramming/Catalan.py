def binom_coeff(n, k):
    res = 1
    for i in range(k):
        res *= (n - i)
        res //= (i + 1)
    return res


def catalan(n):
    cat = binom_coeff(2 * n, n)
    cat //= (n + 1)
    return cat


if __name__ == "__main__":
    n = 10
    print(catalan(n))