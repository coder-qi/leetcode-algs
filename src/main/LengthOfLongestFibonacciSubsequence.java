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
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int len = 0;
                int first = i, second = j;
                while (second < n - 1) {
                    int target = arr[first] + arr[second];
                    if (!map.containsKey(target)) {
                        break;
                    }
                    first = second;
                    second = map.get(target);
                    len = len == 0 ? 3 : len + 1;
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(array("[1,2,3,4,5,6,7,8]"))); // 5
        System.out.println(lenLongestFibSubseq(array("[1,3,7,11,12,14,18]"))); // 3
    }

}
