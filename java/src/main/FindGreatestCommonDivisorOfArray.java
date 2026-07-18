/**
 * 1979. 找出数组的最大公约数：https://leetcode.cn/problems/find-greatest-common-divisor-of-array
 */
public class FindGreatestCommonDivisorOfArray {

    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}
