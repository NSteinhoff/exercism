def is_isogram(string: str) -> bool:
    letters = [l.lower() for l in string if l not in {'-', ' '}]
    return len(letters) == len(set(letters))
