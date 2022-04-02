import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int val = target - numbers[i];
            if (val > numbers[n - 1] || val < numbers[i]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] == val) {
                    return new int[] {i + 1, mid + 1};
                } else if (val > numbers[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9))); // [1,2]
        System.out.println(Arrays.toString(twoSum(new int[] {2,3,4}, 6))); // [1,3]
        System.out.println(Arrays.toString(twoSum(new int[] {-1, 0}, -1))); // [1,2]
    }

}
