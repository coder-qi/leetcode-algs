/**
 * 寻找旋转排序数组中的最小值：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        return nums[findMinIndex(nums, 0, nums.length - 1)];
    }

    private static int findMinIndex(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] > nums[right]) {
            return findMinIndex(nums, mid + 1, right);
        } else {
            return findMinIndex(nums, left, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,4,5,1,2}));
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[] {11,13,15,17}));
        System.out.println(findMin(new int[] {2,3,4,5,1}));
        System.out.println(findMin(new int[] {3,1,2}));
    }

}
