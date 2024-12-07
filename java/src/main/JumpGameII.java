/**
 * 跳跃游戏 II：https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public static int jump_me(int[] nums) {
        int n = nums.length, index = 0, steps = 0;
        while (index < n - 1) {
            steps++;
            int start = index + 1, end = Math.min(index + nums[index], n - 1);
            if (end == n - 1) {
                break;
            }
            int jumpIndex = index;
            for (int i = start; i <= end; i++) {
                if (jumpIndex < i + nums[i]) {
                    jumpIndex = i + nums[i];
                    index = i;
                }
            }
        }
        return steps;
    }

    /**
     * 正向查找可到达的最大位置
     */
    public static int jump(int[] nums) {
        int maxPosition = 0, end = 0, n = nums.length;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,1,1,4})); // 2
        System.out.println(jump(new int[] {2,3,0,1,4})); // 2
        System.out.println(jump(new int[] {3,2,1})); // 1
        System.out.println(jump(new int[] {0})); // 0
    }

}
