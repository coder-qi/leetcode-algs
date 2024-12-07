/**
 * 缺失的第一个正数：https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        /*int left = 0, right = nums.length - 1;
        while (left <= right) {
            int num = nums[left];
            if (num <= 0 || num > right + 1 || (num - 1 != left && nums[num - 1] == num)) {
                swap(nums, left, right);
                right--;
            } else {
                if (left == num - 1) {
                    left++;
                } else {
                    swap(nums, left, num - 1);
                }
            }
        }
        return left + 1;*/
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1,2,0})); // 3
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1})); // 2
        System.out.println(firstMissingPositive(new int[] {7,8,9,11,12})); // 1
        System.out.println(firstMissingPositive(new int[] {0,2,2,1,1})); // 3
    }

}
