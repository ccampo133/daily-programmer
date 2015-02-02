#!/usr/bin/python
import sys


# Recursive solution
def fill_recursive(row, col):
    cur_char = grid[row][col]
    grid[row][col] = c
    check(row, col, cur_char, fill_recursive)


# Iterative solution
def fill_iterative(start_row, start_col):
    points = [(start_row, start_col)]
    cur_char = grid[start_row][start_col]
    while len(points) > 0:
        row, col = points.pop()
        grid[row][col] = c
        check(row, col, cur_char, lambda a, b: points.append((a, b)))


def check(row, col, cur_char, func):
    # Check top, bottom, left, and right (with wrap around)
    if row - 1 > 0 and grid[row - 1][col] == cur_char:
        func(row - 1, col)
    elif row - 1 == 0 and grid[h - 1][col] == cur_char:
        func(h - 1, col)

    if row + 1 < h and grid[row + 1][col] == cur_char:
        func(row + 1, col)
    elif row + 1 == h and grid[0][col] == cur_char:
        func(0, col)

    if col - 1 > 0 and grid[row][col - 1] == cur_char:
        func(row, col - 1)
    elif col - 1 == 0 and grid[row][w - 1] == cur_char:
        func(row, w - 1)

    if col + 1 < w and grid[row][col + 1] == cur_char:
        func(row, col + 1)
    elif col + 1 == w and grid[row][0] == cur_char:
        func(row, 0)


with open(sys.argv[2], "r") as f:
    w, h = map(int, f.readline().split())
    grid = [list(f.readline())[:-1] for j in range(h)]
    x, y, c = f.readline().split()
    x, y = int(x), int(y)

if sys.argv[1] == "-r":
    fill_recursive(y, x)
elif sys.argv[1] == "-i":
    fill_iterative(y, x)
else:
    exit(1)

print("\n".join("".join(*zip(*row)) for row in grid))
