import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积：https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // left product
        for (int i = 1, product = 1; i < n; i++) {
            product *= nums[i - 1];
            ans[i] = product;
        }
        ans[0] = 1;
        // right product
        for (int i = n - 2, product = 1; i >= 0; i--) {
            product *= nums[i + 1];
            ans[i] *= product;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1,1,0,-3,3})));
    }

}
