def sum_of_multiples(limit, multiples):
    return sum({
        x
        for x in range(limit)
        for m in multiples
        if x % m == 0
    })
