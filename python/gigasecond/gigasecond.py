from datetime import timedelta


GIGA = 10**9


def add_gigasecond(d):
    return d + timedelta(seconds=GIGA)
