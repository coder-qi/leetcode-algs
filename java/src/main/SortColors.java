import java.util.Arrays;

/**
 * 颜色分类：https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            while (left <= right && nums[left] == 2) {
                swap(nums, left, right);
                right--;
            }
            while (left <= right && nums[left] != 2) {
                if (nums[left] == 0) {
                    swap(nums, index, left);
                    index++;
                }
                left++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {2,0,1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1};
        sortColors(nums3);
        System.out.println(Arrays.toString(nums3));
    }

}
