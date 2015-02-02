#!/usr/bin/python
import sys


def fill(row, col):
    cur_char = grid[row][col]
    grid[row][col] = c

    # Check top, bottom, left, and right (with wrap around)
    if row - 1 > 0 and grid[row - 1][col] == cur_char:
        fill(row - 1, col)
    elif row - 1 == 0 and grid[h - 1][col] == cur_char:
        fill(h - 1, col)

    if row + 1 < w and grid[row + 1][col] == cur_char:
        fill(row + 1, col)
    elif row + 1 == h and grid[0][col] == cur_char:
        fill(0, col)

    if col - 1 > 0 and grid[row][col - 1] == cur_char:
        fill(row, col - 1)
    elif col - 1 == 0 and grid[row][w - 1] == cur_char:
        fill(row, w - 1)

    if col + 1 < h and grid[row][col + 1] == cur_char:
        fill(row, col + 1)
    elif col + 1 == h and grid[row][0] == cur_char:
        fill(row, 0)


with open(sys.argv[1], 'r') as f:
    w, h = map(int, f.readline().split())
    grid = [list(f.readline())[:-1] for j in range(h)]
    x, y, c = f.readline().split()
    x, y = int(x), int(y)

fill(y, x)
print '\n'.join(''.join(*zip(*row)) for row in grid)
