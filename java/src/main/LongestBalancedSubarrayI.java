import java.util.HashSet;
import java.util.Set;

/**
 * 3719. 最长平衡子数组 I：https://leetcode.cn/problems/longest-balanced-subarray-i
 */
public class LongestBalancedSubarrayI {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Set<Integer> vis = new HashSet<>(n);
        for (int i = 1; i < n; i++) {
            int diff = 0;
            for (int j = i; j >= 0; j--) {
                if (vis.add(nums[j])) {
                    diff += ((nums[j] & 1) << 1) - 1;
                }
                if (diff == 0) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
            vis.clear();
        }
        return ans;
    }

}
