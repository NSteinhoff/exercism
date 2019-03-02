from itertools import groupby


def abbreviate(words):
    return "".join(
        next(g).upper()
        for k, g in groupby(words, lambda c: c.isalpha() or c == "'")
        if k
    )
