/**
 * 974. 和可被 K 整除的子数组：https://leetcode.cn/problems/subarray-sums-divisible-by-k
 */
public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k + 1];
        int ans = 0;
        int s = 0;
        count[0] = 1;
        for (int num : nums) {
            s = (s + num % k + k) % k;
            ans += count[s];
            count[s]++;
        }
        return ans;
    }

}
