import java.util.Arrays;

/**
 * 565. 数组嵌套：https://leetcode.cn/problems/array-nesting/
 */
public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        int ans = 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(nums, memo, i));
        }
        return ans;
    }

    private static int dfs(int[] nums, int[] memo, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }
        memo[index] = 0;
        memo[index]  = 1 + dfs(nums, memo, nums[index]);
        return memo[index];
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[] {5,4,0,3,1,6,2})); // 4
    }

}
