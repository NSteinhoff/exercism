ITEMS = [
    'eggs',
    'peanuts',
    'shellfish',
    'strawberries',
    'tomatoes',
    'chocolate',
    'pollen',
    'cats'
]
SCORES = {
    item: 2**i for i, item in enumerate(ITEMS)
}

class Allergies(object):

    def __init__(self, score):
        self.score = score

    def is_allergic_to(self, item):
        return bool(SCORES[item] & self.score)

    @property
    def lst(self):
        return [
            item for item, score
            in SCORES.items()
            if score & self.score
        ]
