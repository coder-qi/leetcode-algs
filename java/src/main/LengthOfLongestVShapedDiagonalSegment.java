/**
 * 3459. 最长 V 形对角线段的长度：https://leetcode.cn/problems/length-of-longest-v-shaped-diagonal-segment
 */
public class LengthOfLongestVShapedDiagonalSegment {

    private int[][] directs = new int[][] {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][][] memo = new int[m][n][16];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    ans = Math.max(ans, dfs(grid, directs[d][0] + i, directs[d][1] + j, 1 | d << 1 | 0x8, memo) + 1);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int k, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        int turn = k & 1;
        int direct = (k >> 1) & 0x3;
        int x = (k >> 2) & 0x2;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != x) {
            return 0;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        int res = dfs(grid, directs[direct][0] + i, directs[direct][1] + j, k ^ 0x8, memo);
        if (turn != 0) {
            int nd = (direct + 1) % 4;
            res = Math.max(res, dfs(grid, directs[nd][0] + i, directs[nd][1] + j, (nd << 1 | x << 2) ^ 0x8, memo));
        }
        return memo[i][j][k] = res + 1;
    }

}
