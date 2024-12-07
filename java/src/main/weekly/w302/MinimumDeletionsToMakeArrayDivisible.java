
package weekly.w302;

import java.util.Arrays;

import util.ArrayUtils;

/**
 * 6122. 使数组可以被整除的最少删除次数：https://leetcode.cn/problems/minimum-deletions-to-make-array-divisible/
 */
public class MinimumDeletionsToMakeArrayDivisible {

    public static int minOperations(int[] nums, int[] numsDivide) {
        int p = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            p = gcd(p, numsDivide[i]);
        }
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (p % nums[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        //System.out.println(minOperations(null, new int[] {9,6,9,3,15}));
        //System.out.println(minOperations(null, new int[] {8,2,6,10}));
        //System.out.println(minOperations(new int[] {3,2,6,2,35,5,35,2,5,8,7,3,4}, new int[] {105,70,70,175,105,105,105}));
        System.out.println(minOperations(new int[] {2,2}, new int[] {964351116}));
    }

}
