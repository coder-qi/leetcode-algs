import util.ArrayUtils;

/**
 * 3381. 长度可被 K 整除的子数组的最大元素和：https://leetcode.cn/problems/maximum-subarray-sum-with-length-divisible-by-k
 */
public class MaximumSubarraySumWithLengthDivisibleByK {

    public long maxSubarraySum(int[] nums, int k) {
        long[] sumArr = new long[nums.length];
        long max = Long.MIN_VALUE;
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i + 1 < k) {
                sumArr[i] = Long.MIN_VALUE;
                continue;
            }
            long x = sum;
            int prevIndex = i - k;
            if (prevIndex >= 0 && sumArr[prevIndex] > 0) {
                x += sumArr[prevIndex];
            }
            sumArr[i] = x;
            max = Math.max(max, x);
            sum -= nums[i - k + 1];
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarraySumWithLengthDivisibleByK app = new MaximumSubarraySumWithLengthDivisibleByK();
        System.out.println(app.maxSubarraySum(ArrayUtils.array("[1,2]"), 1)); // 3
        System.out.println(app.maxSubarraySum(ArrayUtils.array("[-5,1,2,-3,4]"), 2)); // 4
    }

}
