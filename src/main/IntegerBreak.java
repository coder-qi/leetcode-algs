/**
 * 343. 整数拆分：https://leetcode.cn/problems/integer-break/description/
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        int[] mem = new int[n + 1];
        return process(n, true, mem);
    }

    public static int process(int n, boolean first, int[] mem) {
        if (mem[n] != 0) {
            return mem[n];
        }
        int ans = 1;
        int max = first ? n - 1 : n;
        for (int i = 1; i <= max; i++) {
            ans = Math.max(ans, i * process(n - i, false, mem));
        }
        return mem[n] = ans;
    }

    // 暴力解法
    public static int integerBreak1(int n) {
        return process1(n, true);
    }

    public static int process1(int n, boolean first) {
        int ans = 1;
        int max = first ? n - 1 : n;
        for (int i = 1; i <= max; i++) {
            ans = Math.max(ans, i * process1(n - i, false));
        }
        return ans;
    }

    // 动态规划
    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2)); // 1
        System.out.println(integerBreak(3)); // 2
        System.out.println(integerBreak(5)); // 6
        System.out.println(integerBreak(10)); // 36
        System.out.println(integerBreak(15)); // 243
        System.out.println(integerBreak2(44)); // 9565938
        System.out.println(integerBreak2(58)); // 1549681956
    }

}
