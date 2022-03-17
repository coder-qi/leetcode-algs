import util.ArrayUtils;

/**
 * 被围绕的区域：https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    static int[][] directs = new int[][] {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dp = new int[m][n];

        int row = 0, column = 0;
        for (int i = 0; i < directs.length; i++) {
            int[] direct = directs[i];
            while (row >= 0 && row < m && column >= 0 && column < n) {
                dp[row][column] = 1;
                if (board[row][column] == 'O') {
                    dp[row][column] = 2;
                    int[] nextDirect = directs[(i + 1) % directs.length];
                    solve(row + nextDirect[0], column + nextDirect[1], board, dp);
                }
                row += direct[0];
                column += direct[1];
            }
            row -= direct[0];
            column -= direct[1];

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = dp[i][j] == 2 ? 'O' : 'X';
            }
        }
    }

    private static void solve(int row, int column, char[][] board, int[][] dp) {
        int m = board.length, n = board[0].length;
        if (row < 0 || row >= m || column < 0 || column >= n
                || board[row][column] == 'X' || dp[row][column] != 0) {
            return;
        }
        dp[row][column] = 2;
        for (int[] direct : directs) {
            int nextRow = row + direct[0];
            int nextColumn = column + direct[1];
            solve(nextRow, nextColumn, board, dp);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        solve(board);
        System.out.println(ArrayUtils.print(board));

        board = new char[][] { {'X'} };
        solve(board);
        System.out.println(ArrayUtils.print(board));

        board = new char[][] {
            {'X','O','X','X'},
            {'O','X','O','X'},
            {'X','O','X','O'},
            {'O','X','O','X'}
        };
        solve(board);
        System.out.println(ArrayUtils.print(board));

        board = new char[][] {
            {'O','X','X','O','X'},
            {'X','O','O','X','O'},
            {'X','O','X','O','X'},
            {'O','X','O','O','O'},
            {'X','X','O','X','O'}
        };
        solve(board);
        System.out.println(ArrayUtils.print(board));

        board = new char[][] { {'O'} };
        solve(board);
        System.out.println(ArrayUtils.print(board));
    }

}
