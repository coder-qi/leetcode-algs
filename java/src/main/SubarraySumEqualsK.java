import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组：https://leetcode.cn/problems/subarray-sum-equals-k
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += cnt.getOrDefault(sum - k, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        new SubarraySumEqualsK().subarraySum(new int[]{1,1,1}, 2);
        new SubarraySumEqualsK().subarraySum(new int[]{1,2,1,2,1}, 3);
    }

}
