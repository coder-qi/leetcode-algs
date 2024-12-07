import java.util.Arrays;

/**
 * 3011. 判断一个数组是否可以变为有序：https://leetcode.cn/problems/find-if-array-can-be-sorted
 */
public class FindIfArrayCanBeSorted {

    public static boolean canSortArray(int[] nums) {
        int N = nums.length;
        int i = 0;
        int j = 1;
        while (i < N) {
            int bitCount = Integer.bitCount(nums[i]);
            while (j < N && bitCount == Integer.bitCount(nums[j])) {
                j++;
            }
            Arrays.sort(nums, i, j);
            i = j;
            j = i + 1;
        }
        for (int k = 1; k < N; k++) {
            if (nums[k] < nums[k - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean canSortArray2(int[] nums) {
        int N = nums.length;
        int i = 0;
        int j = 1;
        int preMax = Integer.MIN_VALUE;
        while (i < N) {
            int bitCount = Integer.bitCount(nums[i]);
            int max = nums[i];
            int min = nums[i];
            while (j < N && bitCount == Integer.bitCount(nums[j])) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                j++;
            }
            if (min < preMax) {
                return false;
            }
            preMax = max;
            i = j;
            j = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canSortArray(new int[] {20,16}));
    }

}
