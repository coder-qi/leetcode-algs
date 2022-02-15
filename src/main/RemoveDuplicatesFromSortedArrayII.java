import util.ArrayUtils;

/**
 * 删除有序数组中的重复项 II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(ArrayUtils.print(nums, removeDuplicates(nums)));

        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(ArrayUtils.print(nums2, removeDuplicates(nums2)));
    }

}
