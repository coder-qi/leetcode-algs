package biweekly.w78;

/**
 * 6067. 分割数组的方案数：https://leetcode.cn/problems/number-of-ways-to-split-array/
 */
public class NumberOfWaysToSplitArray {

    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (sum[i] >= sum[n - 1] - sum[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
