import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后：https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        backtrace(n, queens, result, 0);
        return result;
    }

    private static void backtrace(int n, int[] queens , List<List<String>> result, int row) {
        if (row == n) {
            result.add(toQueenList(queens));
            return;
        }
        for (int i = 1; i <= n; i++) {
            boolean b = true;
            for (int j = 0; j < row; j++) {
                if (queens[j] == i || row - j == Math.abs(queens[j] - i)) {
                    b = false;
                    break;
                }
            }
            if (!b) {
                continue;
            }

            queens[row] = i;
            backtrace(n, queens, result, row + 1);
            queens[row] = 0;
        }
    }

    private static List<String> toQueenList(int[] queens) {
        int n = queens.length;
        List<String> result = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                if (queens[i] - 1 == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(1));
    }

}
