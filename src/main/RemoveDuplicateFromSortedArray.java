/**
 * 删除有序数组中的重复项：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicateFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int left = 1, right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    private static String print(int[] nums, int len) {
        if (nums == null)
            return "null";
        int iMax = len - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < len; i++) {
            b.append(nums[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
        return b.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        System.out.println(print(nums1, removeDuplicates(nums1)));
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(print(nums2, removeDuplicates(nums2)));
    }

}
