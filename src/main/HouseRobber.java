/**
 * 打家劫舍：https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        int first = nums[0], second = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int t = second;
            second = Integer.max(first + nums[i], second);
            first = t;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}));
        System.out.println(rob(new int[] {2,7,9,3,1}));
        System.out.println(rob(new int[] {1,7,9,4}));
        System.out.println(rob(new int[] {2,1,1,2}));
        System.out.println(rob(new int[] {2,4,2}));
        System.out.println(rob(new int[] {1,3,1,3,100}));
    }

}
