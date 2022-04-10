package weekly.w288;

import java.util.Arrays;

/**
 * K 次增加后的最大乘积:https://leetcode-cn.com/contest/weekly-contest-288/problems/maximum-product-after-k-increments/
 */
public class MaximumProductAfterKIncrements {

    public static int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        while (k > 0) {
            int j = 0;
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            long d = j == nums.length - 1 ? 1000000 : nums[j + 1] - nums[j];
            if (k >= d * (j + 1)) {
                for (int i = 0; i <= j; i++) {
                    nums[i] += d;
                }
                k -= d * (j + 1);
            } else {
                int c = k / (j + 1);
                int m = k % (j + 1);
                for (int i = j; i >= 0; i--) {
                    nums[i] += c + (m-- > 0 ? 1 : 0);
                }
                k = 0;
            }
        }
        long result = nums[0];
        int m = (int) (Math.pow(10, 9) + 7);
        for (int i = 1; i < nums.length; i++) {
            result = (result * nums[i]) % m;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[] {0,4}, 5));
        System.out.println(maximumProduct(new int[] {6,3,3,2}, 2));
        System.out.println(maximumProduct(new int[] {9,7,8}, 9));
        System.out.println(maximumProduct(new int[] {24,5,64,53,26,38}, 54));
        System.out.println(maximumProduct(new int[] {92,36,15,84,57,60,72,86,70,43,16}, 62));
    }

}
