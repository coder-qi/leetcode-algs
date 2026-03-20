import java.util.Arrays;

/**
 * 3567. 子矩阵的最小绝对差：https://leetcode.cn/problems/minimum-absolute-difference-in-sliding-submatrix/
 */
public class MinimumAbsoluteDifferenceInSlidingSubmatrix {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                res[i][j] = minAbsDiff(grid, i, j, k);
            }
        }
        return res;
    }

    private int minAbsDiff(int[][] grid, int i, int j, int k) {
        int[] nums = new int[k * k];
        for (int l = 0, a = 0; l < k; l++) {
            for (int r = 0; r < k; r++) {
                nums[a++] = grid[i + l][j + r];
            }
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int l = 1; l < nums.length; l++) {
            int a = nums[l - 1];
            int b = nums[l];
            if (a != b) {
                min = Math.min(min, b - a);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
