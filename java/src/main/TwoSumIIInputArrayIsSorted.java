import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0, j = n - 1; i < n && j >= 0;) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
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
