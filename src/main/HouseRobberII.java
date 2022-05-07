import static util.ArrayUtils.array;

/**
 * 213. 打家劫舍 II：https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
        // 0 ~ n - 1
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            int t = second;
            second = Math.max(first + nums[i], second);
            first = t;
        }
        int ans = second;

        // 1 ~ n
        first = nums[1];
        second = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int t = second;
            second = Math.max(first + nums[i], second);
            first = t;
        }
        ans = Math.max(ans, second);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rob(array("[2,3,2]"))); // 3
        System.out.println(rob(array("[1,2,3,1]"))); // 4
        System.out.println(rob(array("[1,2,3]"))); // 3
    }

}
