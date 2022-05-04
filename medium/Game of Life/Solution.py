def totalSurAlive(board, row: int, col: int) -> int:
    sum = 0
    total_col = len(board[0])
    total_row = len(board)
    if col-1 >= 0:
        sum += board[row][col-1]
    if col+1 < total_col:
        sum += board[row][col+1]

    if row-1 >= 0:
        if col-1 >= 0:
            sum += board[row-1][col-1]
        if col+1 < total_col:
            sum += board[row-1][col+1]
        sum += board[row-1][col]

    if row+1 < total_row:
        if col-1 >= 0:
            sum += board[row+1][col-1]
        if col+1 < total_col:
            sum += board[row+1][col+1]
        sum += board[row+1][col]

    return sum


def gameOfLife(board) -> None:
    new_board = []

    total_row = len(board)
    for i in range(total_row):
        new_board.append(board[i].copy())

    total_col = len(board[0])

    for r in range(total_row):
        for c in range(total_col):
            sur_alive = totalSurAlive(board, r, c)
            cur = board[r][c]

            if cur == 0:
                if sur_alive == 3:
                    new_board[r][c] = 1
            else:
                if sur_alive < 2 or sur_alive > 3:
                    new_board[r][c] = 0

    for r in range(total_row):
        for c in range(total_col):
            board[r][c] = new_board[r][c]


arr = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
gameOfLife(arr)
x = 0
