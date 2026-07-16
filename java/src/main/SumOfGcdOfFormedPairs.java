import java.util.Arrays;

/**
 * 3867. 数对的最大公约数之和：https://leetcode.cn/problems/sum-of-gcd-of-formed-pairs
 */
public class SumOfGcdOfFormedPairs {

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        long ans = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            ans += gcd(prefixGcd[i], prefixGcd[j]);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

}
