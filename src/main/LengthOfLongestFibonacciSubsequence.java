import java.util.HashMap;

import static util.ArrayUtils.array;

/**
 * 873. 最长的斐波那契子序列的长度：https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
public class LengthOfLongestFibonacciSubsequence {

    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(array("[1,2,3,4,5,6,7,8]"))); // 5
        System.out.println(lenLongestFibSubseq(array("[1,3,7,11,12,14,18]"))); // 3
    }

}
