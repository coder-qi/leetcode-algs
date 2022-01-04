import java.util.Arrays;

/**
 * 下一个排列：https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int m = nums.length - 1;
        while (m > 0 && nums[m - 1] > nums[m]) {
            m--;
        }
        if (m > 0) {
            int k = nums.length - 1;
            while (k > 0 && nums[m - 1] >= nums[k]) {
                k--;
            }
            swap(nums, m - 1, k);
        }
        int left = m, right = nums.length - 1;
        while (left < right) {
            if (nums[left] > nums[right]) {
                swap(nums, left++, right--);
            } else {
                break;
            }
        }
        // 1 2 3 4
        // 1 2 4 3
        // 1 3 2 4
        // 1 3 4 2
        // 1 4 2 3
        // 1 4 3 2

        // 1 2 3 4 5
        // 1 2 3 5 4
        // 1 2 4 3 5
        // 1 2 4 5 3
        // 1 2 5 3 4
        // 1 2 5 4 3
        // 1 3 2 4 5
        // 1 3 2 5 4
        // 1 3 4 2 5
        // 5 4 3 2 1
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // [1,3,2]

        int[] nums2 = {3,2,1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1,2,3]

        int[] nums3 = {1,1,5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1,5,1]

        int[] nums4 = {1};
        nextPermutation(nums4);
        System.out.println(Arrays.toString(nums4)); // [1]

        int[] nums5 = {1,3,2};
        nextPermutation(nums5);
        System.out.println(Arrays.toString(nums5)); // [2,1,3]

        int[] nums6 = {2,3,1};
        nextPermutation(nums6);
        System.out.println(Arrays.toString(nums6)); // [3,1,2]
    }

}
