/**
 * 搜索插入位置：https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5)); // 2
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2)); // 1
        System.out.println(searchInsert(new int[] {1,3,5,6}, 7)); // 4
        System.out.println(searchInsert(new int[] {1,3,5,6}, 0)); // 0
        System.out.println(searchInsert(new int[] {1}, 0)); // 0
    }

}
