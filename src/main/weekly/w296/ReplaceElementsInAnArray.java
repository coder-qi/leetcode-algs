package weekly.w296;

import java.util.HashMap;
import java.util.Map;

/**
 * 6092. 替换数组中的元素：https://leetcode.cn/problems/replace-elements-in-an-array/
 */
public class ReplaceElementsInAnArray {

    public static int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int[] op : operations) {
            int index = numMap.remove(op[0]);
            numMap.put(op[1], index);
        }
        int[] ans = new int[nums.length];
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            ans[entry.getValue()] = entry.getKey();
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
