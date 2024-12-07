/**
 * 553. 最优除法：https://leetcode.cn/problems/optimal-division/description/
 */
public class OptimalDivision {

    public static String optimalDivision2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        } else if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder ans = new StringBuilder(n * 4);
        ans.append(nums[0]).append("/(");
        for (int i = 1; i < n; i++) {
            ans.append(nums[i]).append("/");
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.append(")");
        return ans.toString();
    }

}
