/**
 * 688. 骑士在棋盘上的概率：https://leetcode.cn/problems/knight-probability-in-chessboard/
 */

#include <stdio.h>

double knightProbability(int n, int k, int row, int column);

int main()
{
    printf("%f", knightProbability(3, 2, 0, 0));
    return 0;
}

double process(int n, int k, int row, int column, double dp[][n][n])
{
    if (row < 0 || row >= n || column < 0 || column >= n)
        return 0;
    if (k == 0)
        return 1;
    if (dp[k][row][column] != -1.0f)
        return dp[k][row][column];
    double res = 0.0f;
    res += 0.125f * process(n, k - 1, row - 1, column - 2, dp);
    res += 0.125f * process(n, k - 1, row - 2, column - 1, dp);
    res += 0.125f * process(n, k - 1, row - 2, column + 1, dp);
    res += 0.125f * process(n, k - 1, row - 1, column + 2, dp);
    res += 0.125f * process(n, k - 1, row + 1, column + 2, dp);
    res += 0.125f * process(n, k - 1, row + 2, column + 1, dp);
    res += 0.125f * process(n, k - 1, row + 2, column - 1, dp);
    res += 0.125f * process(n, k - 1, row + 1, column - 2, dp);
    return dp[k][row][column] = res;
}

/**
 * 递归版本（记忆化搜索）
 */
double knightProbability2(int n, int k, int row, int column)
{
    double dp[k + 1][n][n];
    for (int m = 0; m <= k; ++m)
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[m][i][j] = -1.0f;
    return process(n, k, row, column, dp);
}

/**
 * dp
 */
double knightProbability(int n, int k, int row, int column)
{
    static int dirs[8][2] = {
            {-1, -2},
            {-2, -1},
            {-2, + 1},
            {-1, +2},
            {+1, +2},
            {+2, +1},
            {+2, -1},
            {+1, -2},
    };
    double dp[k + 1][n][n];
    for (int m = 0; m <= k; ++m)
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[m][i][j] = m == 0 ? 1.0f : 0.0f;
    for (int m = 1; m <= k; ++m)
        for (int r = 0; r < n; ++r)
            for (int c = 0; c < n; ++c)
                for (int p = 0; p < 8; ++p) {
                    int nr = r + dirs[p][0], nc = c + dirs[p][1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n)
                        dp[m][r][c] += 0.125f * dp[m - 1][nr][nc];
                }
    return dp[k][row][column];
}
