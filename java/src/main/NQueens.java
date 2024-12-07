import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后：https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrace(n, queens, result, 0, 0, 0, 0);
        return result;
    }

    private static void backtrace(int n, int[] queens , List<List<String>> result,
        int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            result.add(toQueenList(queens));
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            int column = Integer.bitCount(position - 1);

            queens[row] = column;
            backtrace(n, queens, result, row + 1, columns | position,
                (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            queens[row] = -1;
        }
    }

    private static List<String> toQueenList(int[] queens) {
        int n = queens.length;
        List<String> result = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                if (queens[i] == j) {
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
