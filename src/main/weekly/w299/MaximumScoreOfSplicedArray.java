package weekly.w299;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 2321. 拼接数组的最大分数：https://leetcode.cn/problems/maximum-score-of-spliced-array/
 */
public class MaximumScoreOfSplicedArray {

    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff1 = new int[n], diff2 = new int[n];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff1[i] = nums2[i] - nums1[i];
            diff2[i] = nums1[i] - nums2[i];
        }
        return Math.max(sum1 + maxSubArraySum(diff1), sum2 + maxSubArraySum(diff2));
    }

    private static int maxSubArraySum(int[] nums) {
        int ans = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] >= 0) {
                sum += nums[i];
            } else {
                sum = 0;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumsSplicedArray(array("[60,60,60]"), array("[10,90,10]"))); // 210
        System.out.println(maximumsSplicedArray(array("[20,40,20,70,30]"), array("[50,20,50,40,20]"))); // 220
        System.out.println(maximumsSplicedArray(array("[7,11,13]"), array("[1,1,1]"))); // 31
        System.out.println(maximumsSplicedArray(array(loadTestcase("2321-testcase-1-nums1.txt")), array(loadTestcase("2321-testcase-1-nums2.txt")))); // 999991281
        System.out.println(maximumsSplicedArray(array(loadTestcase("2321-testcase-2-nums1.txt")), array(loadTestcase("2321-testcase-2-nums2.txt")))); // 251217443
    }

}
