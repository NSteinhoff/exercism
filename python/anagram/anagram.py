def detect_anagrams(word, candidates):
    return [c for c in candidates if is_anagram(word, c)]


def is_anagram(this, that):
    this, that = this.lower(), that.lower()
    if this == that:
        return False
    else:
        return sorted(this) == sorted(that)
