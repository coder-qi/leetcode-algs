package weekly.w297;

import java.util.Arrays;

import static util.ArrayUtils.matrix;

/**
 * 5270. 网格中的最小路径代价：https://leetcode.cn/problems/minimum-path-cost-in-a-grid/
 */
public class MinimumPathCostInAGrid {

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Integer.min(ans, dfs(grid, moveCost, memo, 0, i));
        }
        return ans;
    }

    private static int dfs(int[][] grid, int[][] moveCost, int[][] memo, int row, int column) {
        int m = grid.length, n = grid[0].length;
        if (row == m - 1) {
            return grid[row][column];
        }
        if (memo[row][column] != -1) {
            return memo[row][column];
        }
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = grid[row][column] + moveCost[grid[row][column]][i]
                + dfs(grid, moveCost, memo, row + 1, i);
            v = Math.min(v, c);
        }
        memo[row][column] = v;
        return v;
    }

    public static void main(String[] args) {
        System.out.println(minPathCost(matrix("[[5,3],[4,0],[2,1]]"), matrix("[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]")));
        System.out.println(minPathCost(matrix("[[5,1,2],[4,0,3]]"), matrix("[[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]")));
    }

}
