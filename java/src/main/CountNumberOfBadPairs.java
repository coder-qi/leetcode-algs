import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目：https://leetcode.cn/problems/count-number-of-bad-pairs
 */
public class CountNumberOfBadPairs {

    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>(nums.length, 1);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = cnt.getOrDefault(nums[i] - i, 0);
            ans += i - c;
            cnt.put(nums[i] - i, c + 1);
        }
        return ans;
    }

}
