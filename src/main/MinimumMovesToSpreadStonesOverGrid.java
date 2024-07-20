/**
 * 2850. 将石头分散到网格图的最少移动次数：https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid
 */
public class MinimumMovesToSpreadStonesOverGrid {

    public static int minimumMoves(int[][] grid) {
        return process(grid, 0, 0);
    }

    private static int process(int[][] grid, int row, int column) {
        int M = grid.length;
        int N = grid[0].length;
        if (grid[row][column] != 0) {
            if (column + 1 < N) {
                return process(grid, row, column + 1);
            } else if (row + 1 == M) {
                return 0;
            } else {
                return process(grid, row + 1, 0);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] <= 1) {
                    continue;
                }
                grid[row][column] = 1;
                grid[i][j]--;
                min = Math.min(min, process(grid, row, column) + Math.abs(i - row) + Math.abs(j - column));
                grid[i][j]++;
                grid[row][column] = 0;
            }
        }
        return min;
    }


}
