import java.util.HashMap;
import java.util.HashSet;

/**
 * 2657. 找到两个数组的前缀公共数组：https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays
 */
public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        boolean[] visa = new boolean[n + 1];
        boolean[] visb = new boolean[n + 1];
        int[] ans = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            visa[a[i]] = true;
            visb[b[i]] = true;
            if (visa[a[i]] && visb[a[i]]) {
                cnt++;
            }
            if (a[i] != b[i] && visa[b[i]] && visb[b[i]]) {
                cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }

}
