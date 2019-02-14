from collections import Counter
# Score categories
# Change the values as you see fit
YACHT = 0
ONES = 1
TWOS = 2
THREES = 3
FOURS = 4
FIVES = 5
SIXES = 6
FULL_HOUSE = 7
FOUR_OF_A_KIND = 8
LITTLE_STRAIGHT = 9
BIG_STRAIGHT = 10
CHOICE = 11


def score(dice, category):
    counter = Counter(dice)
    counts = set(counter.values())

    if category == YACHT and counts == {5}:
        return 50

    # The categories for plain numbers match the sides of the dice.
    if category in counter:
        return counter[category] * category

    if category == FULL_HOUSE and counts == {2, 3}:
        return sum(dice)

    if category == FOUR_OF_A_KIND:
        return sum(4 * kind for kind, count in counter.items() if count >= 4)

    if category == CHOICE:
        return sum(dice)

    if category == LITTLE_STRAIGHT and list(sorted(dice)) == list(range(1, 6)):
        return 30

    if category == BIG_STRAIGHT and list(sorted(dice)) == list(range(2, 7)):
        return 30
    return 0
