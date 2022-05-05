/**
 * 713. 乘积小于 K 的子数组：https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product >= k) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100)); // 8
        System.out.println(numSubarrayProductLessThanK(new int[] {1,2,3}, 0)); // 0
    }

}
