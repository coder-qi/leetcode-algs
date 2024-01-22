import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2809. 使数组和小于等于 x 的最少时间：https://leetcode.cn/problems/minimum-time-to-make-array-sum-at-most-x/description/
 */
public class MinimumTimeToMakeArraySumAtMostX {

    public static int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        // TODO 待做
        int n = nums1.size();
        int[][] sortedNums2 = new int[n][2];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sortedNums2[i][0] = i;
            sortedNums2[i][1] = nums2.get(i);
            sum1 += nums1.get(0);
            sum2 += nums2.get(0);
        }
        Arrays.sort(sortedNums2, Comparator.comparingInt(o -> o[1]));
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int b = sortedNums2[i - 1][0], a = sortedNums2[i - 1][1];
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1] + nums1.get(b) + (j - 1) * a);
            }
        }
        for (int j = 1; j <= n; j++) {
            if (sum1 + j * sum2 - dp[n][j] <= x) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(Arrays.asList(4,4,9,10), Arrays.asList(4,4,1,3), 16)); // 4
        System.out.println(minimumTime(Arrays.asList(7,9,8,5,8,3), Arrays.asList(0,1,4,2,3,1), 37)); // 2
    }
}
