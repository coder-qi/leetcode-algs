/**
 * 3693. 爬楼梯 II：https://leetcode.cn/problems/climbing-stairs-ii
 */
public class ClimbingStairsII {

    public int climbStairs(int n, int[] costs) {
        int[] f = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            f[j] = Integer.MAX_VALUE;
            for (int i = j - 1; i >= 0 && i >= j - 3 ; i--) {
                f[j] = Math.min(f[j], f[i] + costs[j - 1] + (i - j) * (i - j));
            }
        }
        return f[n];
    }

    public int climbStairs2(int n, int[] costs) {
        int[] f = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            f[j] = f[j - 1] + costs[j - 1] + 1;
            if (j - 2 >= 0) {
                f[j] = Math.min(f[j], f[j - 2] + costs[j - 1] + 4);
            }
            if (j - 3 >= 0) {
                f[j] = Math.min(f[j], f[j - 3] + costs[j - 1] + 9);
            }
        }
        return f[n];
    }

    public int climbStairs3(int n, int[] costs) {
        int f0 = 0, f1 = 0, f2 = 0;
        for (int j = 1; j <= n; j++) {
            int newF = f2 + costs[j - 1] + 1;
            if (j - 2 >= 0) {
                newF = Math.min(newF, f1 + costs[j - 1] + 4);
            }
            if (j - 3 >= 0) {
                newF = Math.min(newF, f0 + costs[j - 1] + 9);
            }
            f0 = f1;
            f1 = f2;
            f2 = newF;
        }
        return f2;
    }


}
