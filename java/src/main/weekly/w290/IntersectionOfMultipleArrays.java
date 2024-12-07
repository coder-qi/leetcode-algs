package weekly.w290;

import java.util.*;

/**
 * 2248. 多个数组求交集：https://leetcode.cn/problems/intersection-of-multiple-arrays/
 */
public class IntersectionOfMultipleArrays {

    public static List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                count.put(nums[i][j], count.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == nums.length) {
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {

    }

}
