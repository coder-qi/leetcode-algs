package weekly.w286;

import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 2217. 找到指定长度的回文数：https://leetcode.cn/problems/find-palindrome-with-fixed-length/
 */
public class FindPalindromeWithFixedLength {


    public static long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        int len = (intLength + 1) / 2;
        int start = (int) (Math.pow(10, len - 1) - 1), limit = (int) (Math.pow(10, len) - 1);
        long[] ans = new long[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (start + queries[i] > limit) {
                ans[i] = -1;
            } else {
                sb.setLength(0);
                sb.append(start + queries[i]);
                for (int j = intLength - len - 1; sb.length() < intLength; j--) {
                    sb.append(sb.charAt(j));
                }
                ans[i] = Long.valueOf(sb.toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthPalindrome(array("[1,2,3,4,5,90]"), 3)));
        System.out.println(Arrays.toString(kthPalindrome(array("[2,4,6]"), 4)));
    }

}
