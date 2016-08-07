import string


def is_pangram(sentence):
    return not [c for c in string.ascii_lowercase
                if c not in sentence.lower()]
