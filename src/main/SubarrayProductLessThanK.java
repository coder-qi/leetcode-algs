/**
 * 713. 乘积小于 K 的子数组：https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        long product = 1;
        for (int right = 0, left = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100)); // 8
        System.out.println(numSubarrayProductLessThanK(new int[] {1,2,3}, 0)); // 0
    }

}
