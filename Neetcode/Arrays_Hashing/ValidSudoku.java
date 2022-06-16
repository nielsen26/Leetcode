package Arrays_Hashing;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] hor = new boolean[9];
            boolean[] ver = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    if (hor[val - 1])
                        return false;
                    hor[val - 1] = true;
                }

                if (board[j][i] != '.') {
                    int val = Character.getNumericValue(board[j][i]);
                    if (ver[val - 1])
                        return false;
                    ver[val - 1] = true;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] small = new boolean[9];
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (board[row][col] != '.') {
                            int val = Character.getNumericValue(board[row][col]);
                            if (small[val - 1])
                                return false;
                            small[val - 1] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
