import java.util.Arrays;

/**
 * 最大间距：https://leetcode-cn.com/problems/maximum-gap/
 */
public class MaximumGap {

    public static int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        Arrays.fill(arr, -1);
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = nums[i];
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == -1) {
                arr[i] = arr[i - 1];
            } else {
                result = Math.max(arr[i] - arr[i - 1], result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumGap(new int[] {3,6,9,1}));
        System.out.println(maximumGap(new int[] {10}));
    }

}
