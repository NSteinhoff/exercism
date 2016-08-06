class Clock(object):
    def __init__(self, hours, minutes):
        self.hours = hours
        self.minutes = minutes

    def __str__(self):
        total_hours = self.hours + int(self.minutes//60)
        shift_hours = total_hours % 24
        shift_minutes = self.minutes % 60
        return "{h:02d}:{m:02d}".format(h=shift_hours, m=shift_minutes)

    def add(self, minutes):
        self.minutes += minutes
        return self

    def __eq__(self, other):
        return str(self) == str(other)
