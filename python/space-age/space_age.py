class SpaceAge(object):
    base = 31557600
    factors = dict(
        earth=1.0,
        mercury=0.2408467,
        mars=1.8808158,
        jupiter=11.862615,
        saturn=29.447498,
        uranus=84.016846,
        neptune=164.79132,
        venus=0.61519726)

    def __init__(self, seconds):
        self.seconds = seconds

    def __getattr__(self, name):
        planet = name[3:]
        factor = self.factors[planet]
        return lambda: self._years(factor)

    def _years(self, factor):
        return round(self.seconds / (self.base * factor), 2)
