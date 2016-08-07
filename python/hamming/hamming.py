def distance(xs, ys):
    return sum(x != y for x, y in zip(xs, ys))
