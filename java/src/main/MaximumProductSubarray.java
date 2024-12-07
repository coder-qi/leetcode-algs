/**
 * 乘积最大子数组：https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int result = nums[0], maxF = nums[0], minF = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxF, min = minF;
            maxF = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            minF = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
            result = Math.max(result, maxF);
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
