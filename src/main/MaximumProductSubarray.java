/**
 * 乘积最大子数组：https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int result = nums[0], a = 1;
        for (int i = 0; i < nums.length; i++) {
            a = a != 0 ? a * nums[i] : nums[i];
            result = Math.max(result, a);
        }
        a = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            a = a != 0 ? a * nums[i] : nums[i];
            result = Math.max(result, a);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2,3,-2,4}));
        System.out.println(maxProduct(new int[] {-2,0,-1}));
        System.out.println(maxProduct(new int[] {0,2}));
        System.out.println(maxProduct(new int[] {2,-5,-2,-4,3}));
        System.out.println(maxProduct(new int[] {3,-2,-3,-3,1,3,0}));
        System.out.println(maxProduct(new int[] {-3,2,3}));
    }

}
