/**
 * 搜索旋转排序数组：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int left, int right) {
        if (nums[left] <= nums[right]) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        } else {
            int mid = (left + right) / 2;
            int ans = search(nums, target, left, mid);
            if (ans != -1) {
                return ans;
            }
            return search(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(search(new int[] {1}, 0)); // -1
    }

}
