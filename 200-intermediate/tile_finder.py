#!/usr/bin/python
import sys

with open(sys.argv[1], "r") as f:
    w, h = map(int, f.readline().split())
    grid = [list(f.readline())[:-1] for j in range(h)]

tiles = []
for y in range(h):
    for x in range(w):
        c = grid[y][x]
        if c != "." and (y - 1 == -1 or grid[y - 1][x] != c) and (x - 1 == -1 or grid[y][x - 1] != c):
            tiles.append({"c": c, "x": x, "y": y, "w": 0, "h": 0})

for tile in tiles:
    x, y, c = tile["x"], tile["y"], tile["c"]
    i, j = x, y
    while i < w and grid[y][i] == c:
        tile["w"] += 1
        i += 1
    while j < h and grid[j][x] == c:
        tile["h"] += 1
        j += 1

for tile in tiles:
    print ("%sx%s tile of character '%s' located at (%s, %s)" % (tile["w"], tile["h"], tile["c"], tile["x"], tile["y"]))
