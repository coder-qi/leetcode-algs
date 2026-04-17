import java.util.HashMap;
import java.util.Map;

/**
 * 3761. 镜像对之间最小绝对距离：https://leetcode.cn/problems/minimum-absolute-distance-between-mirror-pairs
 */
public class MinimumAbsoluteDistanceBetweenMirrorPairs {

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> r = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = reverse(nums[i]);
            if (r.containsKey(x)) {
                ans = Math.min(ans, r.get(x) - i);
            }
            r.put(nums[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

}
