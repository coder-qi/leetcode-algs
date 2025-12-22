import java.util.Arrays;

/**
 * 960. 删列造序 III：https://leetcode.cn/problems/delete-columns-to-make-sorted-iii
 */
public class DeleteColumnsToMakeSortedIII {

    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int[] memo = new int[m];
        Arrays.fill(memo, -1);
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dfs(strs, i, memo));
        }
        return m - max;
    }

    private int dfs(String[] strs, int i, int[] memo) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = 1;
        for (int j = i - 1; j >= 0; j--) {
            boolean ok = true;
            for (String str : strs) {
                if (str.charAt(j) > str.charAt(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res = Math.max(res, 1 + dfs(strs, j, memo));
            }
        }
        return memo[i] = res;
    }

    public int minDeletionSize2(String[] strs) {
        int m = strs[0].length();
        int[] f = new int[m];
        Arrays.fill(f, 1);
        int maxF = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (f[i] >= f[j] + 1) {
                    continue;
                }
                boolean ok = true;
                for (String str : strs) {
                    if (str.charAt(j) > str.charAt(i)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            maxF = Math.max(maxF, f[i]);
        }
        return m - maxF;
    }

}
