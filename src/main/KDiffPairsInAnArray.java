import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static util.ArrayUtils.array;

/**
 * 532. 数组中的 k-diff 数对：https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */
public class KDiffPairsInAnArray {

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && k !=0) {
                continue;
            }
            if (k == 0) {
                if (map.getOrDefault(nums[i], 0) == 1) {
                    ans++;
                }
            } else {
                int target = nums[i] - k;
                if (map.containsKey(target)) {
                    ans++;
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(array("[3, 1, 4, 1, 5]"), 2)); // 2
        System.out.println(findPairs(array("[1, 2, 3, 4, 5]"), 1)); // 4
        System.out.println(findPairs(array("[1, 3, 1, 5, 4]"), 0)); // 1
        System.out.println(findPairs(array("[1,2,4,4,3,3,0,9,2,3]"), 3)); // 2
    }

}
