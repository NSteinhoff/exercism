from calendar import monthrange
from datetime import date


class MeetupDayException(Exception):
    pass

DAYS = {
    'Monday': 0,
    'Tuesday': 1,
    'Wednesday': 2,
    'Thursday': 3,
    'Friday': 4,
    'Saturday': 5,
    'Sunday': 6,
}
IDCS = {
    '1st': 0,
    '2nd': 1,
    '3rd': 2,
    '4th': 3,
    '5th': 4,
    'last': -1,
}


def meetup_day(year, month, weekday, nth):
    _, last_day = monthrange(year, month)
    days_in_month = [date(year, month, i).day for i in range(1, last_day+1)
                     if date(year, month, i).weekday() == DAYS[weekday]]
    if nth == 'teenth':
        day = [d for d in days_in_month if d <= 19 and d >= 13][0]
    else:
        try:
            day = days_in_month[IDCS[nth]]
        except:
            raise MeetupDayException('No {} {}'.format(nth, weekday))

    return date(year, month, day)
