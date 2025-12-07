/**
 * 2698. 求一个整数的惩罚数：https://leetcode.cn/problems/find-the-punishment-number-of-an-integer
 */
public class FindThePunishmentNumberOfAnInteger {

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            char[] str = String.valueOf(i * i).toCharArray();
            Boolean[][] memo = new Boolean[str.length][i + 1];
            if (dfs(str, 0, 0, i, memo)) {
                ans += i * i;
            }
        }
        return ans;
    }

    private boolean dfs(char[] str, int i, int s, int target, Boolean[][] memo) {
        if (i >= str.length) {
            return s == target;
        }
        if (s > target) {
            return false;
        }
        if (memo[i][s] != null) {
            return memo[i][s];
        }
        int x = 0;
        boolean res = false;
        for (int j = i; j < str.length; j++) {
            x = x * 10 + (str[j] - '0');
            if (dfs(str, j + 1, s + x, target, memo)) {
                res = true;
                break;
            }
        }
        return memo[i][s] = res;
    }

}
