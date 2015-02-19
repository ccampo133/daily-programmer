#!/usr/bin/env python

import sys
import math

# Anonymous (Meeus/Jones/Butcher) Gregorian algorithm
# http://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm
year = int(sys.argv[1])
a = year % 19
b = year / 100
c = year % 100
d = b / 4
e = b % 4
f = (b + 8) / 25
g = (b - f + 1) / 3
h = (19 * a + b - d - g + 15) % 30
i = (32 + 2 * e + 2 * (c / 4) - h - (c % 4)) % 7
j = (a + 11 * h + 22 * i) / 451
k = h + i - 7 * j + 114
month = k / 31
day = k % 31 + 1

print("%d-%02d-%02d" % (year, month, day))
