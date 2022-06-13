def helpPath(heights, row: int, col: int, min_eff: int, max_step: int) -> int:
    max_row = len(heights)
    max_col = len(heights[0])
    if row == max_row-1 and col == max_col-1:
        return max_step
    cur_val = heights[row][col]

    if row+1 < max_row and heights[row+1][col] != 0 and abs(heights[row][col] - heights[row+1][col]) < min_eff:
        heights[row][col] = 0
        min_eff = helpPath(heights, row+1, col, min_eff,
                           max(max_step, abs(heights[row][col] - heights[row+1][col])))
        heights[row][col] = cur_val
    if col+1 < max_col and heights[row][col+1] != 0 and abs(heights[row][col] - heights[row][col+1]) < min_eff:
        heights[row][col] = 0
        min_eff = helpPath(heights, row, col+1, min_eff,
                           max(max_step, abs(heights[row][col+1] - heights[row][col])))
        heights[row][col] = cur_val
    if row-1 >= 0 and heights[row-1][col] != 0 and abs(heights[row][col] - heights[row-1][col]) < min_eff:
        heights[row][col] = 0
        min_eff = helpPath(heights, row-1, col, min_eff,
                           max(max_step, abs(heights[row][col] - heights[row-1][col])))
        heights[row][col] = cur_val
    if col-1 >= 0 and heights[row][col-1] != 0 and abs(heights[row][col] - heights[row][col-1]) < min_eff:
        heights[row][col] = 0
        min_eff = helpPath(heights, row, col-1, min_eff,
                           max(max_step, abs(heights[row][col-1] - heights[row][col])))
        heights[row][col] = cur_val

    return min_eff


def minimumEffortPath(heights) -> int:
    max_row = len(heights)
    max_col = len(heights[0])
    min_eff = 0
    for i in range(max_row):
        if i+1 < max_row:
            min_eff = max(min_eff, abs(heights[i][0] - heights[i+1][0]))
    max_col = len(heights[0])
    for j in range(max_col):
        if j+1 < max_col:
            min_eff = max(min_eff, abs(
                heights[max_row-1][j] - heights[max_row-1][j+1]))

    cur_val = heights[0][0]

    if 1 < max_row and abs(heights[0][0] - heights[1][0]) < min_eff:
        heights[0][0] = 0
        min_eff = helpPath(heights, 1, 0, min_eff,
                           abs(heights[0][0] - heights[1][0]))
        heights[0][0] = cur_val
    if 1 < max_col and abs(heights[0][1] - heights[0][0]) < min_eff:
        heights[0][0] = 0
        min_eff = helpPath(heights, 0, 1, min_eff,
                           abs(heights[0][1] - heights[0][0]))
        heights[0][0] = cur_val

    return min_eff


minimumEffortPath([[1, 2, 3], [3, 8, 4], [5, 3, 5]])
