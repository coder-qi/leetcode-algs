/**
 * 搜索旋转排序数组 II：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static boolean search(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target;
        }
        if (nums[left] < nums[right]) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        } else {
            int mid = (left + right) / 2;
            if (search(nums, target, left, mid)) {
                return true;
            }
            return search(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {2,5,6,0,0,1,2}, 0)); // true
        System.out.println(search(new int[] {2,5,6,0,0,1,2}, 3)); // false
    }

}
