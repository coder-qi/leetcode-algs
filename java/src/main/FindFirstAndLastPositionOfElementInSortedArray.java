import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 先查找到目标值，然后再扩大其范围
     */
    public static int[] searchRange2(int[] nums, int target) {
        int left = 0, right = nums.length - 1, j = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                j = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (j == -1) {
            return new int[] {-1, -1};
        }
        left = right = j;
        while (left >= 1 && nums[left - 1] == target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        return new int[] {left, right};
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length
                && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[] {leftIndex, rightIndex};
        }
        return new int[] {-1, -1};
    }

    private static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] == target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8))); // [3,4]
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6))); // [-1,-1]
        System.out.println(Arrays.toString(searchRange(new int[] {}, 0))); // [-1,-1]
        System.out.println(Arrays.toString(searchRange(new int[] {1,1,2}, 1))); // [0,1]
    }

}
