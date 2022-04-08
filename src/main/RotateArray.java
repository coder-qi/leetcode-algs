import java.util.Arrays;

/**
 * 轮转数组：https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        int[] temp = new int[k];
        // 交换0 ~ k
        for (int i = 0; i < k; i++) {
            temp[i] = nums[(i + k) % n];
            nums[(i + k) % n] = nums[i];
        }
        // k ~ n
        for (int i = k; i < n; i++) {
            int t = nums[(i + k) % n];
            nums[(i + k) % n] = temp[i % k];
            temp[i % k] = t;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums)); // [5,6,7,1,2,3,4]
        nums = new int[] {-1,-100,3,99};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
