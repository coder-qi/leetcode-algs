import java.util.Arrays;

/**
 * 2090. 半径为 k 的子数组平均值：https://leetcode.cn/problems/k-radius-subarray-averages
 */
public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < 2 * k) {
                continue;
            }
            ans[i - k] = (int) (sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }
        return ans;
    }

}
