import numpy as np


# Generates a 2D bit array of dimensions (w, h), with a
# disk of ones with radius `r`, centered at point (x, y).
# All other points in the array are zero valued.
def disk(r, x, y, h, w):
    ind = np.indices((h, w))
    return r ** 2.0 >= (ind[0] - y) ** 2.0 + (ind[1] - x) ** 2.0

with open("input.txt", "r") as f:
    h, w, r = map(int, f.readline().split())
    # Convert x to 1 and everything else (.) to 0.
    grid = [np.array(map(lambda c: 1 if c == 'x' else 0, f.readline()[:-1])) for j in range(h)]

max = 0
for i in range(h):
    for j in range(w):
        sum = (grid * disk(r, (i, j), (h, w))).sum()
        if sum >= max:
            max = sum
            x, y = j, i

print((x, y), max)
