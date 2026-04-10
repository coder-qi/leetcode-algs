import java.util.HashMap;
import java.util.Map;

/**
 * 3740. 三个相等元素之间的最小距离 I：https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-i
 */
public class MinimumDistanceBetweenThreeEqualElementsI {

    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> m = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
           if (!m.containsKey(nums[i])) {
               m.put(nums[i], new int[]{i, -1});
           } else {
               int[] a = m.get(nums[i]);
               if (a[1] != -1) {
                   ans = Math.min(ans, (i - a[0]) * 2);
                   a[0] = a[1];
               }
               a[1] = i;
           }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
