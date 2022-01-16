/**
 * 跳跃游戏：https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxJumpIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && maxJumpIndex <= i) {
                return false;
            }
            if (maxJumpIndex >= nums.length - 1) {
                return true;
            }
            maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2,3,1,1,4})); // true
        System.out.println(canJump(new int[] {3,2,1,0,4})); // false
        System.out.println(canJump(new int[] {3,2,1,0,4})); // false
        System.out.println(canJump(new int[] {3,0,8,2,0,0,1})); // true
        System.out.println(canJump(new int[] {2,5,0,0})); // true
    }

}
