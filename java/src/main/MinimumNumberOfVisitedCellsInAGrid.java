import java.util.Arrays;

import static util.ArrayUtils.matrix;
import static util.ResourceUtils.loadTestcase;

/**
 * 2617. 网格图中最少访问的格子数：https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid
 */
public class MinimumNumberOfVisitedCellsInAGrid {

/*    private int[][] grid;
    private int m;
    private int n;*/

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        ST[] rowSTS = new ST[m];
        ST[] columnSTS = new ST[n];
        for (int i = 0; i < m; i++) {
            rowSTS[i] = new ST(n);
        }
        for (int i = 0; i < n; i++) {
            columnSTS[i] = new ST(m);
        }

        for (int row = m - 1; row >= 0; row--) {
            for (int column = n - 1; column >= 0; column--) {
                if (row == m - 1 && column == n - 1) {
                    dp[row][column] = 1;
                } else {
                    /*int res = Integer.MAX_VALUE;
                    for (int k = column + 1; k <= Math.min(grid[row][column] + column, n - 1); k++) {
                        res = Math.min(res, dp[row][k]);
                    }
                    for (int k = row + 1; k <= Math.min(grid[row][column] + row, m - 1); k++) {
                        res = Math.min(res, dp[k][column]);
                    }
                    dp[row][column] = (res == Integer.MAX_VALUE ? res : res + 1);*/

                    int p1 = (int) rowSTS[row].query(column + 2, Math.min(grid[row][column] + column, n - 1) + 1, 1, n, 1);
                    int p2 = (int) columnSTS[column].query(row + 2, Math.min(grid[row][column] + row, m - 1) + 1, 1, m, 1);
                    int res = Math.min(p1, p2);
                    dp[row][column] = (res == Integer.MAX_VALUE ? res : res + 1);

                }
                rowSTS[row].update(column + 1, column + 1, dp[row][column], 1, n, 1);
                columnSTS[column].update(row + 1, row + 1, dp[row][column], 1, m, 1);
            }
        }
        return dp[0][0] == Integer.MAX_VALUE ? -1 : dp[0][0];
    }

    private static class ST {
        int[] min;
        boolean[] update;
        int[] change;

        ST(int n) {
            min = new int[n << 2];
            update = new boolean[n << 2];
            change = new int[n << 2];
            Arrays.fill(min, Integer.MAX_VALUE);
        }

        private void pushUp(int rt) {
            min[rt] = Math.min(min[rt << 1], min[rt << 1 | 1]);
        }

        private void pushDown(int rt, int ln, int rn) {
            if (update[rt]) {
                update[rt << 1] = true;
                update[rt << 1 | 1] = true;
                change[rt << 1] = change[rt];
                change[rt << 1 | 1] = change[rt];
                min[rt << 1] = Math.min(change[rt], min[rt << 1]);
                min[rt << 1 | 1] = Math.min(change[rt], min[rt << 1 | 1]);
                update[rt] = false;
            }
        }

        public void update(int L, int R, int C, int l, int r, int rt) {
            if (l >= L && r <= R) {
                update[rt] = true;
                change[rt] = C;
                min[rt] = Math.min(min[rt], C);
                return;
            }
            int mid = (l + r) >> 1;
            pushDown(rt, mid - l + 1, r - mid);
            if (mid >= L) {
                update(L, R, C, l, mid, rt << 1);
            }
            if (mid < R) {
                update(L, R, C, mid + 1, r, rt << 1 | 1);
            }
            pushUp(rt);
        }

        public long query(int L, int R, int l, int r, int rt) {
            if (l >= L && r <= R) {
                return min[rt];
            }
            long ans = Integer.MAX_VALUE;
            int mid = (l + r) >> 1;
            pushDown(rt, mid - l + 1, r - mid);
            if (mid >= L) {
                ans = Math.min(ans, query(L, R, l, mid, rt << 1));
            }
            if (mid < R) {
                ans = Math.min(ans, query(L, R, mid + 1, r, rt << 1 | 1));
            }
            return ans;
        }
    }

    /*private int process(int row, int column, int[][] dp) {
        if (row == m - 1 && column == n - 1) {
            return 0;
        }
        if (dp[row][column] != 0) {
            return dp[row][column];
        }
        int res = Integer.MAX_VALUE;
        for (int k = column + 1; k <= Math.min(grid[row][column] + column, n - 1); k++) {
            res = Math.min(res, process(row, k, dp));
        }
        for (int k = row + 1; k <= Math.min(grid[row][column] + row, m - 1); k++) {
            res = Math.min(res, process(k, column, dp));
        }
        return dp[row][column] = (res == Integer.MAX_VALUE ? res : res + 1);
    }*/

    public static void main(String[] args) {
        MinimumNumberOfVisitedCellsInAGrid s = new MinimumNumberOfVisitedCellsInAGrid();
        System.out.println(s.minimumVisitedCells(matrix("[[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]")));
        long start = System.currentTimeMillis();
        System.out.println(s.minimumVisitedCells(matrix(loadTestcase("2617-testcase-1.txt"))));
        System.out.println("cost: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(s.minimumVisitedCells(matrix(loadTestcase("2617-testcase-2.txt"))));
        System.out.println(System.currentTimeMillis() - start);
    }

}
