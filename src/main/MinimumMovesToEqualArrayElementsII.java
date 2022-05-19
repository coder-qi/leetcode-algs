import java.util.Arrays;
import java.util.Random;

import static util.ArrayUtils.array;

/**
 * 462. 最少移动次数使数组元素相等 II：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElementsII {

    Random random = new Random();

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - mid);
        }
        return ans;
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int q = randomPartition(nums, left, right);
        if (q == k) {
            return nums[q];
        } else {
            return q < k ? quickSelect(nums, q + 1, right, k)
                : quickSelect(nums, left, q - 1, k);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int x = nums[right], i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(array("[1,2,3]"))); // 2
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(array("[1,10,2,9]"))); // 16
    }

}
