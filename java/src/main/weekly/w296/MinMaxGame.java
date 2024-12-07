package weekly.w296;

import static util.ArrayUtils.array;

/**
 * 6090. 极大极小游戏：https://leetcode.cn/problems/min-max-game/
 */
public class MinMaxGame {

    public static int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            n /= 2;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(minMaxGame(array("[1,3,5,2,4,8,2,2]")));
    }

}
