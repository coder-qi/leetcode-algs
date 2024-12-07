import java.util.Random;

/**
 * 398. 随机数索引：https://leetcode-cn.com/problems/random-pick-index/
 */
public class RandomPickIndex {

    static class Solution {

        int[] nums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int result = 0;
            for (int i = 0, cnt = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                    if (random.nextInt(cnt) == 0) {
                        result = i;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[] {1, 2, 3, 3, 3});
        solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
        solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
    }

}
