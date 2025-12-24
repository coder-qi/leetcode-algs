/**
 * 62. 不同路径：https://leetcode.cn/problems/unique-paths
 */

#include <string.h>

int dfs(int i, int j, int m, int n, int memo[m][n]) {
    if (i == 0 && j == 0) {
        return 1;
    }
    if (i < 0 || j < 0) {
        return 0;
    }
    if (memo[i][j] != -1) {
        return memo[i][j];
    }
    return memo[i][j] = dfs(i, j - 1, m, n, memo) + dfs(i - 1, j, m, n, memo);
}

int uniquePaths(int m, int n) {
    int memo[m][n];
    memset(memo, -1, sizeof(memo));
    return dfs(m - 1, n - 1, m, n, memo);
}

int uniquePaths2(int m, int n) {
    int f[m][n];
    memset(f, 0, sizeof(f));
    for (int i = 0; i < m; i++) {
        f[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        f[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            f[i][j] = f[i][j - 1] + f[i - 1][j];
        }
    }
    return f[m - 1][n - 1];
}

int uniquePaths3(int m, int n) {
    int f[n];
    for (int j = 0; j < n; j++) {
        f[j] = 1;
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            f[j] += f[j - 1];
        }
    }
    return f[n - 1];
}

int main(int argc, char *argv[]) {
    uniquePaths2(3, 7);
}
