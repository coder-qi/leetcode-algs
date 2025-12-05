/**
 * 3432. 统计元素和差值为偶数的分区方案：https://leetcode.cn/problems/count-partitions-with-even-sum-difference
 */
public class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int ans = 0;
        int s = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            s += nums[i];
            if (((total - s * 2) & 1) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
