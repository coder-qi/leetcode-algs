import java.util.Arrays;

/**
 * 轮转数组：https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums)); // [5,6,7,1,2,3,4]
        nums = new int[] {-1,-100,3,99};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        rotate(nums, 38);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1,2,3,4,5,6};
        rotate(nums, 4);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        rotate(nums, 29);
        System.out.println(Arrays.toString(nums));
    }

}
