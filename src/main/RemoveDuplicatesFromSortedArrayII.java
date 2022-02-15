import util.ArrayUtils;

/**
 * 删除有序数组中的重复项 II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int n = nums.length, i = 0, j = 0;
        while (i < n) {
            if (i == n - 1 || nums[i] != nums[i + 1]) {
                nums[j++] = nums[i++];
            }
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[j++] = nums[i++];
            }
            if (i < n && nums[i - 1] == nums[i]) {
                nums[j++] = nums[i++];
            }
            while (i < n && nums[i - 1] == nums[i]) {
                i++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(ArrayUtils.print(nums, removeDuplicates(nums)));

        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(ArrayUtils.print(nums2, removeDuplicates(nums2)));
    }

}
