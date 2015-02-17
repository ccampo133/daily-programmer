#!/usr/bin/env python

import binascii, sys

with open (sys.argv[1], "r") as f:
    text = f.read().replace('\n', '')

print(binascii.unhexlify('%x' % int(text, 2)))
