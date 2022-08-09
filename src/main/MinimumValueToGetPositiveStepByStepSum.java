/**
 * 1413. 逐步求和得到正数的最小值：https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class MinimumValueToGetPositiveStepByStepSum {

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[] {-3,2,-3,4,2})); // 5
        System.out.println(minStartValue(new int[] {1,2})); // 1
        System.out.println(minStartValue(new int[] {1,-2,-3})); // 5
    }

    public static int minStartValue(int[] nums) {
        int min = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        return Math.max(1,  -min + 1);
    }

}
