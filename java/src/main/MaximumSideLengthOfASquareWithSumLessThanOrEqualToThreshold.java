import util.ArrayUtils;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长：https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = mat[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0;
                int right = Math.min(m - i, n - j);
                while (left < right) {
                    int mid = (left + right) / 2;
                    int sum = preSum[i + mid + 1][j + mid + 1] - preSum[i][j + mid + 1] - preSum[i + mid + 1][j] + preSum[i][j];
                    if (sum <= threshold) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                ans = Math.max(ans, left);
            }
        }
        return ans;
    }

    public int maxSideLength2(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = mat[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (i + ans < m && j + ans < n && query(preSum, i, j, i + ans, j + ans) <= threshold) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int query(int[][] preSum, int r1, int c1, int r2, int c2) {
        return preSum[r2 + 1][c2 + 1] - preSum[r1][c2 + 1] - preSum[r2 + 1][c1] + preSum[r1][c1];
    }

    public static void main(String[] args) {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold app = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
        System.out.println(app.maxSideLength2(ArrayUtils.matrix("[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]"), 4));
        System.out.println(app.maxSideLength2(ArrayUtils.matrix("[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]"), 1));
    }

}
