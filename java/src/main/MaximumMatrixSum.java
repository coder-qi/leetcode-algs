import util.ArrayUtils;

/**
 * 1975. 最大方阵和：https://leetcode.cn/problems/maximum-matrix-sum
 */
public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int negativeCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int x : row) {
                if (x >= 0) {
                    ans += x;
                    minPositive = Math.min(minPositive, x);
                } else {
                    ans -= x;
                    negativeCount++;
                    maxNegative = Math.max(maxNegative, x);
                }
            }
        }
        if (negativeCount % 2 == 0) {
            return ans;
        } else {
            return -maxNegative > minPositive ? ans - minPositive * 2 : ans + maxNegative * 2;
        }
    }

    public static void main(String[] args) {
        MaximumMatrixSum mms = new MaximumMatrixSum();
        System.out.println(mms.maxMatrixSum(ArrayUtils.matrix("[[1,2,3],[-1,-2,-3],[1,2,3]]"))); // 16
        System.out.println(mms.maxMatrixSum(ArrayUtils.matrix("[[2,9,3],[5,4,-4],[1,7,1]]"))); // 34
    }

}
