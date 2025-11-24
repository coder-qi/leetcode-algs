import java.util.HashMap;
import java.util.Map;

/**
 * 2461. 长度为 K 子数组中的最大和：https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>(k);
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
            if (i + 1 < k) {
                continue;
            }

            if (cnt.size() == k) {
                ans = Math.max(ans, sum);
            }

            int last = nums[i - k + 1];
            sum -= last;
            int j = cnt.get(last);
            if (j == 1) {
                cnt.remove(last);
            } else {
                cnt.put(last, j - 1);
            }
        }
        return ans;
    }

}
