import java.util.Arrays;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 面试题 17.19. 消失的两个数字：https://leetcode.cn/problems/missing-two-lcci/
 */
public class MissingTwoLcci {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingTwo(new int[] {1}))); // [2,3]
        System.out.println(Arrays.toString(missingTwo(new int[] {2,3}))); // [1,4]
        System.out.println(Arrays.toString(missingTwo(
            array(loadTestcase("missing-two-lcci-testcase-1.txt"))))); // [2050, 8184]
    }

    public static int[] missingTwo(int[] nums) {
        int m = nums.length, n = m + 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int missingTwoSum = (1 + n) * n / 2 - sum;
        int mid = missingTwoSum / 2; // 其中一个必定小于等于mid，另一个大于mid
        sum = 0;
        for (int num : nums) {
            if (num <= mid) {
                sum += num;
            }
        }
        int a = (1 + mid) * mid / 2 - sum, b = missingTwoSum - a;
        return new int[] {a, b};
    }
}
