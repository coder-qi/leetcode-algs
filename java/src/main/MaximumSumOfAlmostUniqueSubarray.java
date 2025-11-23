import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2841. 几乎唯一子数组的最大和：https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray
 */
public class MaximumSumOfAlmostUniqueSubarray {

    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.size());
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (i + 1 < k) {
                continue;
            }
            if (map.size() >= m) {
                ans = Math.max(ans, sum);
            }
            int last = nums.get(i - k + 1);
            sum -= last;
            int c = map.get(last);
            if (c == 1) {
                map.remove(last);
            } else {
                map.put(last, c - 1);
            }
        }
        return ans;
    }

}
