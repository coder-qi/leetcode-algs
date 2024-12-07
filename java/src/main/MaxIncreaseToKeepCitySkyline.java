/**
 * 807. 保持城市天际线：https://leetcode.cn/problems/max-increase-to-keep-city-skyline
 */
public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] rowMaxHeight = new int[M];
        int[] columnMaxHeight = new int[N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rowMaxHeight[i] = Math.max(rowMaxHeight[i], grid[i][j]);
                columnMaxHeight[j] = Math.max(columnMaxHeight[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                ans += Math.min(rowMaxHeight[i], columnMaxHeight[j]) - grid[i][j];
            }
        }
        return ans;
    }

}
