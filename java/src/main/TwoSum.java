import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 地址：https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    /**
     * 暴力破解法，时间复杂度O(N^2)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * HashMap查找法，时间复杂度O(N)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null) {
                return new int[] {j, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 4 };
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

}
