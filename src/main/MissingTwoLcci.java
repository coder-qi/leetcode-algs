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
        int n = nums.length + 2;
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        for (int i = 1; i <= n; i++) {
            x ^= i;
        }
        int lsb = x & -x;
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }
        return new int[] {type1, type2};
    }
}
