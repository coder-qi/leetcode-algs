/**
 * 3212. 统计 X 和 Y 频数相等的子矩阵数量：https://leetcode.cn/problems/count-submatrices-with-equal-frequency-of-x-and-y
 */
public class CountSubmatricesWithEqualFrequencyOfXAndY {

    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] prefixSum = new int[m + 1][n + 1][2];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1][0] = prefixSum[i + 1][j][0] + prefixSum[i][j + 1][0] - prefixSum[i][j][0];
                prefixSum[i + 1][j + 1][1] = prefixSum[i + 1][j][1] + prefixSum[i][j + 1][1] - prefixSum[i][j][1];
                if (grid[i][j] == 'X') {
                    prefixSum[i + 1][j + 1][0]++;
                } else if (grid[i][j] == 'Y') {
                    prefixSum[i + 1][j + 1][1]++;
                }
                if (prefixSum[i + 1][j + 1][0] > 0 && prefixSum[i + 1][j + 1][0] == prefixSum[i + 1][j + 1][1]) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
