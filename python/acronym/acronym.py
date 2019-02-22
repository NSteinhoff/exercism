import re


def abbreviate(words):
    # Match the first letter following the beginning of the string
    # or following anything that is not a letter or apostrophe.
    pattern = re.compile(r"(^|[^A-Z'])([A-Z])")

    matches = pattern.findall(words.upper())

    return ''.join(letter for seperator, letter in matches)
