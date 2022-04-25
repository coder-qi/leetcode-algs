import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 398. 随机数索引：https://leetcode-cn.com/problems/random-pick-index/
 */
public class RandomPickIndex {

    static class Solution {

        Map<Integer, List<Integer>> indexes = new HashMap<>();
        Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                indexes.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = indexes.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[] {1, 2, 3, 3, 3});
        solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
        solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
    }

}
