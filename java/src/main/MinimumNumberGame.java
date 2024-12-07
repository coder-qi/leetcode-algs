import java.util.Arrays;

/**
 * 2974. 最小数字游戏：https://leetcode.cn/problems/minimum-number-game
 */
public class MinimumNumberGame {

    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int x = nums[i * 2];
            nums[i * 2] = nums[i * 2 + 1];
            nums[i * 2 + 1] = x;
        }
        return nums;
    }

}
