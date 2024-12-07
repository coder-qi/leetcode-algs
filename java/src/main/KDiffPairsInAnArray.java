import java.util.HashSet;
import java.util.Set;

import static util.ArrayUtils.array;

/**
 * 532. 数组中的 k-diff 数对：https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */
public class KDiffPairsInAnArray {

    public static int findPairs(int[] nums, int k) {
        Set<Integer> res = new HashSet<>(nums.length);
        Set<Integer> visited = new HashSet<>(nums.length);
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(findPairs(array("[3, 1, 4, 1, 5]"), 2)); // 2
        System.out.println(findPairs(array("[1, 2, 3, 4, 5]"), 1)); // 4
        System.out.println(findPairs(array("[1, 3, 1, 5, 4]"), 0)); // 1
        System.out.println(findPairs(array("[1,2,4,4,3,3,0,9,2,3]"), 3)); // 2
    }

}
