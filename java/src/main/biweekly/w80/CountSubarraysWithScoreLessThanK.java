package biweekly.w80;

import static util.ArrayUtils.array;

/**
 * 6098. 统计得分小于 K 的子数组数目：https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/
 */
public class CountSubarraysWithScoreLessThanK {

    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        for (int i = 0, j = 0; i < n; i++) {
            sum += nums[i];
            while (j <= i && sum * (i - j + 1) >= k) {
                sum -= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(array("[2,1,4,3,5]"), 10));
        System.out.println(countSubarrays(array("[1,1,1]"), 5));
    }

}
