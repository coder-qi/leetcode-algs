/**
 * 3653. 区间乘法查询后的异或 I：https://leetcode.cn/problems/xor-after-range-multiplication-queries-i
 */
public class XorAfterRangeMultiplicationQueriesI {

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) (((long) nums[i] * v) % mod);
            }
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

}
