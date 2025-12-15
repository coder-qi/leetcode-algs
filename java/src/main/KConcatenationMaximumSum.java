/**
 * 1191. K 次串联后最大子数组之和：https://leetcode.cn/problems/k-concatenation-maximum-sum
 */
public class KConcatenationMaximumSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1000000007;
        long s = 0;
        long maxSubSingle = 0;
        long minPre = 0, maxPre = 0;
        for (int x : arr) {
            s += x;
            minPre = Math.min(minPre, s);
            maxPre = Math.max(maxPre, s);
            maxSubSingle = Math.max(maxSubSingle, s - minPre);
        }
        long ans = maxSubSingle;
        if (k == 1) {
            return (int) (ans % mod);
        }
        long maxSuf = s - minPre;
        ans = Math.max(ans, maxPre + maxSuf + (k - 2) * Math.max(s, 0));
        return (int) (ans % mod);
    }

}
