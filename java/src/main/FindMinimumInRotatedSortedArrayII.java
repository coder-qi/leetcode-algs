/**
 * 寻找旋转排序数组中的最小值 II：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] == nums[right]) {
            right--;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[] {1,3,5}));
        System.out.println(findMin(new int[] {2,2,2,0,1}));
        System.out.println(findMin(new int[] {5,1,3}));
        System.out.println(findMin(new int[] {3,3,1,3}));
        System.out.println(findMin(new int[] {1,2,1}));
    }

}
