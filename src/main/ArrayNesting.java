import java.util.Arrays;

/**
 * 565. 数组嵌套
 */
public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean[] vis = new boolean[nums.length];
            ans = Math.max(ans, dfs(nums, vis, i));
        }
        return ans;
    }

    private static int dfs(int[] nums, boolean[] vis, int index) {
        if (vis[index]) {
            return 0;
        }
        vis[index] = true;
        return 1 + dfs(nums, vis, nums[index]);
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[] {5,4,0,3,1,6,2})); // 4
    }

}
