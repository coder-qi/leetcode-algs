/**
 * 300. 最长递增子序列：https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18})); // 4
        System.out.println(lengthOfLIS(new int[] {0,1,0,3,2,3})); // 4
        System.out.println(lengthOfLIS(new int[] {7,7,7,7,7,7,7})); // 1
    }

}
