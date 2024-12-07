import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独：https://leetcode-cn.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    /**
     * 直白的解法
     */
    public static boolean isValidSudoku2(char[][] board) {
        Set<Character> set = new HashSet<>(9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c =  board[i][j];
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
            set.clear();

            for (int j = 0; j < 9; j++) {
                char c =  board[j][i];
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
            set.clear();

            for (int n = i % 3, j = n * 3; j < n * 3 + 3; j++) {
                for (int m = i / 3, k = m * 3; k < m * 3 + 3; k++) {
                    char c =  board[j][k];
                    if (c != '.' && !set.add(c)) {
                        return false;
                    }
                }
            }
            set.clear();
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c =  board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i/3][j/3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i/3][j/3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board)); // true

        char[][] board2 = {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board2)); // false
    }

}
