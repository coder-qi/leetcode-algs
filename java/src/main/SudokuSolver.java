import java.util.ArrayList;
import java.util.List;

import util.ArrayUtils;

/**
 * 解数独：https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        // 将对应的位置出现过的数字设置为true
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c =  board[i][j];
                if (c == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int digit = c - '0' - 1;
                    row[i][digit] = true;
                    column[j][digit] = true;
                    block[i/3][j/3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        // 已经处理完了
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!row[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]) {
                row[i][digit] = true;
                column[j][digit] = true;
                block[i/3][j/3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);

                dfs(board, pos + 1);

                row[i][digit] = false;
                column[j][digit] = false;
                block[i/3][j/3][digit] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        new SudokuSolver3().solveSudoku(board);
        System.out.println(ArrayUtils.print(board));
        /*[["5","3","4","6","7","8","9","1","2"],
        ["6","7","2","1","9","5","3","4","8"],
        ["1","9","8","3","4","2","5","6","7"],
        ["8","5","9","7","6","1","4","2","3"],
        ["4","2","6","8","5","3","7","9","1"],
        ["7","1","3","9","2","4","8","5","6"],
        ["9","6","1","5","3","7","2","8","4"],
        ["2","8","7","4","1","9","6","3","5"],
        ["3","4","5","2","8","6","1","7","9"]]*/
    }

}

/**
 * 使用位运算进行优化
 */
class SudokuSolver2 {
    int[] row = new int[9];
    int[] column = new int[9];
    int[][] block = new int[3][3];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        // 将对应的位置出现过的数字设置为true
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c =  board[i][j];
                if (c == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int digit = c - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        // 已经处理完了
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(row[i] | column[j] | block[i/3][j/3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);

            dfs(board, pos + 1);

            flip(i, j, digit);
        }
    }

    private void flip(int i, int j, int digit) {
        row[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i/3][j/3] ^= (1 << digit);
    }

}

/**
 * 枚举优化，在空白处的值唯一时就直接填入
 */
class SudokuSolver3 {
    int[] row = new int[9];
    int[] column = new int[9];
    int[][] block = new int[3][3];
    List<int[]> spaces = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        // 将对应的位置出现过的数字设置为true
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c =  board[i][j];
                if (c != '.') {
                    int digit = c - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        int mask = ~(row[i] | column[j] | block[i/3][j/3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][j] = (char) (digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c =  board[i][j];
                if (c == '.') {
                    spaces.add(new int[] {i, j});
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        // 已经处理完了
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(row[i] | column[j] | block[i/3][j/3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);

            dfs(board, pos + 1);

            flip(i, j, digit);
        }
    }

    private void flip(int i, int j, int digit) {
        row[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i/3][j/3] ^= (1 << digit);
    }

}