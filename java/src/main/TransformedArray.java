/**
 * 3379. 转换数组：https://leetcode.cn/problems/transformed-array/
 */
public class TransformedArray {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = (nums[i] % n + i + n) % n;
            ans[i] = nums[j];
        }
        return ans;
    }

}
