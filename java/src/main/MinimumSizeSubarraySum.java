/**
 * 209. 长度最小的子数组：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, sum = 0;
        int ans = n + 1;
        while (right < n) {
            while (right < n && sum < target) {
                sum += nums[right++];
            }
            while (left < right && sum - nums[left] >= target) {
                sum -= nums[left++];
            }
            if (sum >= target) {
                ans = Math.min(ans, right - left);
            }
            sum -= nums[left++];
        }
        if (ans > n) {
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[] {1,4,4}));
        System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
    }

}
