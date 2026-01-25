import util.ArrayUtils;

import java.util.Arrays;

/**
 * 3363. 最多可收集的水果数目：https://leetcode.cn/problems/find-the-maximum-number-of-fruits-collected
 */
public class FindTheMaximumNumberOfFruitsCollected {

    private final int[][] directs2 = new int[][]{{1, -1}, {1, 0}, {1, 1}};
    private final int[][] directs3 = new int[][]{{-1, 1}, {0, 1}, {1, 1}};

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        // 第一个小朋友只能走对角线
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
        }
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 其他小朋友不要经过对角线
        ans += dfs(fruits, 0, n - 1, directs2, memo);
        ans += dfs(fruits, n - 1, 0, directs3, memo);
        return ans;
    }

    private int dfs(int[][] fruits, int i, int j, int[][] directs, int[][] memo) {
        int n = fruits.length;
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        for (int[] direct : directs) {
            int ni = i + direct[0];
            int nj = j + direct[1];
            if (i > j) {
                if (ni > nj) {
                    res = Math.max(res, dfs(fruits, ni, nj, directs, memo));
                }
            } else {
                if (ni < nj) {
                    res = Math.max(res, dfs(fruits, ni, nj, directs, memo));
                }
            }
        }
        return memo[i][j] = res + fruits[i][j];
    }

    public int maxCollectedFruits2(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        // 第一个小朋友只能走对角线
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
        }
        int[][] f = new int[n][n];
        // 第二个小朋友
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                int best = 0;
                for (int[] d : directs2) {
                    int pi = i + d[0];
                    int pj = j + d[1];
                    if (pi >= 0 && pi < n && pj >= 0 && pj < n && pj > pi) {
                        best = Math.max(best, f[pi][pj]);
                    }
                }
                f[i][j] = best + fruits[i][j];
            }
        }
        // 第三个小朋友
        for (int j = n - 1; j >= 0; j--) {
            for (int i = n - 1; i > j ; i--) {
                int best = 0;
                for (int[] d : directs3) {
                    int pi = i + d[0];
                    int pj = j + d[1];
                    if (pi >= 0 && pi < n && pj >= 0 && pj < n && pi > pj) {
                        best = Math.max(best, f[pi][pj]);
                    }
                }
                f[i][j] = best + fruits[i][j];
            }
        }
        ans += f[0][n - 1] + f[n - 1][0];
        return ans;
    }


    public int maxCollectedFruits3(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        // 第一个小朋友只能走对角线
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
        }
        int[] f1 = new int[n];
        int[] f2 = new int[n];
        // 第二个小朋友
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                int best = 0;
                for (int[] d : directs2) {
                    int pi = i + d[0];
                    int pj = j + d[1];
                    if (pi >= 0 && pi < n && pj >= 0 && pj < n && pj > pi) {
                        best = Math.max(best, f1[pj]);
                    }
                }
                f2[j] = best + fruits[i][j];
            }
            int[] temp = f1;
            f1 = f2;
            f2 = temp;
        }
        ans += f1[n - 1];

        f1 = new int[n];
        f2 = new int[n];
        // 第三个小朋友
        for (int j = n - 1; j >= 0; j--) {
            for (int i = n - 1; i > j ; i--) {
                int best = 0;
                for (int[] d : directs3) {
                    int pi = i + d[0];
                    int pj = j + d[1];
                    if (pi >= 0 && pi < n && pj >= 0 && pj < n && pi > pj) {
                        best = Math.max(best, f1[pi]);
                    }
                }
                f2[i] = best + fruits[i][j];
            }
            int[] temp = f1;
            f1 = f2;
            f2 = temp;
        }
        ans += f1[n - 1];
        return ans;
    }


    public static void main(String[] args) {
        FindTheMaximumNumberOfFruitsCollected app = new FindTheMaximumNumberOfFruitsCollected();
        System.out.println(app.maxCollectedFruits3(ArrayUtils.matrix("[[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]")));
    }

}
