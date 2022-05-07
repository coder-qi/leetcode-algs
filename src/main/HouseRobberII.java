import static util.ArrayUtils.array;

/**
 * 213. 打家劫舍 II：https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
        // 0 ~ n - 1
        int[] dp = new int[n - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int ans = dp[n - 2];

        // 1 ~ n
        dp = new int[n];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        ans = Math.max(ans, dp[n - 1]);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rob(array("[2,3,2]"))); // 3
        System.out.println(rob(array("[1,2,3,1]"))); // 4
        System.out.println(rob(array("[1,2,3]"))); // 3
    }

}
