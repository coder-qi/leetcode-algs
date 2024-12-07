import java.util.Arrays;

/**
 * 396. 旋转函数：https://leetcode-cn.com/problems/rotate-function/
 */
public class RotateFunction {

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length, f = 0, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int result = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            result = Math.max(result, f);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[] {4,3,2,6})); // 26
        System.out.println(maxRotateFunction(new int[] {100})); // 0
    }

}
