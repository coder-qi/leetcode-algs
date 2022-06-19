package weekly.w286;

import java.util.Arrays;

import util.ArrayUtils;

import static util.ArrayUtils.array;

/**
 * 2217. 找到指定长度的回文数：https://leetcode.cn/problems/find-palindrome-with-fixed-length/
 */
public class FindPalindromeWithFixedLength {

    static final int[] count = new int[16];
    static {
        count[0] = 1;
        count[1] = 10;
        count[2] = 9;
        for (int i = 3; i <= 15; i++) {
            if (i % 2 == 0) {
                count[i] = count[i - 1];
            } else {
                count[i] = count[i - 2] * 9;
            }
        }
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] result = new long[n];
        int[] arr = new int[intLength];
        for (int i = 0; i < n; i++) {
            int k = queries[i];
            if (k > count[intLength]) {
                result[i] = -1;
                continue;
            }
            for (int j = intLength; j >= (intLength + 1) / 2 + (intLength % 2 == 0 ? 1 : 0); j--) {
                if (j > 2) {
                    if (k % count[j - 2] == 0) {
                        for (int l = j; l >= (intLength + 1) / 2; l--) {
                            arr[intLength - l] = arr[l - 1] = 9;
                        }
                        break;
                    }
                    k %= count[j - 2];
                    int p = k / count[j - 2] + 1;
                    arr[intLength - j] = arr[j - 1] = p;
                } else if (k != 0) {
                    if (k <= 9) {
                        arr[j - 1] = k - 1;
                    } else {
                        arr[intLength - j] = arr[j - 1] = k % 10;
                    }
                }
            }
            int v = 0;
            for (int j = 0; j < intLength; j++) {
                v = v * 10 + arr[j];
            }
            result[i] = v;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthPalindrome(array("[1,2,3,4,5,90]"), 3)));
        System.out.println(Arrays.toString(kthPalindrome(array("[2,4,6]"), 4)));
    }

}
