/**
 * 寻找旋转排序数组中的最小值 II：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        return nums[findMinIndex(nums, 0, nums.length - 1)];
    }

    private static int findMinIndex(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) >> 1;
        if (nums[left] == nums[right]) {
            int l = findMinIndex(nums, left, mid);
            int r = findMinIndex(nums, mid + 1, right);
            return nums[l] < nums[r] ? l : r;
        } else {
            if (nums[mid] > nums[right]) {
                return findMinIndex(nums, mid + 1, right);
            } else {
                return findMinIndex(nums, left, mid);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {1,3,5}));
        System.out.println(findMin(new int[] {2,2,2,0,1}));
        System.out.println(findMin(new int[] {5,1,3}));
        System.out.println(findMin(new int[] {3,3,1,3}));
    }

}
