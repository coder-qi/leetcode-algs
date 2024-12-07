/**
 * 565. 数组嵌套：https://leetcode.cn/problems/array-nesting/
 */
public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        int ans = 0;
        boolean[] vis = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[] {5,4,0,3,1,6,2})); // 4
    }

}
