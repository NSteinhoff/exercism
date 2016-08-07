# -*- coding: utf-8 -*-
import re
from collections import Counter


def word_count(sentence):
    words = [w.lower() for w
             in re.split('\W+|_', sentence)  # split on any non-word char or _
             if re.match('\w+', w)]          # only if it's word-like not ''
    return Counter(words)
