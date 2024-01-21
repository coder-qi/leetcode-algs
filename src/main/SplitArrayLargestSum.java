/**
 * 410. 分割数组的最大值：https://leetcode.cn/problems/split-array-largest-sum/description/
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(left, num);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int x, int k) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num > x) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {7,2,5,10,8}, 2)); // 18
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,2,3,4,5}, 2)); // 9
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,4,4}, 3)); // 4
    }

}
