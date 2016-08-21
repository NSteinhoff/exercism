import itertools
import re


def encode(x):
    counts = [(len(list(g)), c) for c, g in itertools.groupby(x)]
    return ''.join(str(e) for cs in counts for e in cs if e != 1)


def decode(x):
    return re.sub(r'(\d+)(\D)', lambda m: m.group(2) * int(m.group(1)), x)
