/**
 * N 皇后II：https://leetcode-cn.com/problems/n-queens-ii/
 */
public class NQueensII {

    private int total;

    public int totalNQueens(int n) {
        backtrace(n,0, 0, 0, 0);
        return total;
    }

    private void backtrace(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            total++;
            return;
        }
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            backtrace(n, row + 1, columns | position,
                (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
        System.out.println(new NQueensII().totalNQueens(1));
    }

}
