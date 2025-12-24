/**
 * 63. 不同路径 II：https://leetcode.cn/problems/unique-paths-ii
 */

#include <string.h>

int dfs(int i, int j, int m, int n, int** obstacleGrid, int memo[m][n]) {
    if (i < 0 || j < 0) {
        return 0;
    }
    if (obstacleGrid[i][j] == 1) {
        return 0;
    }
    if (i == 0 && j == 0) {
        return 1;
    }
    if (memo[i][j] != -1) {
        return memo[i][j];
    }
    return memo[i][j] = dfs(i - 1, j, m, n, obstacleGrid, memo) + dfs(i, j - 1, m, n, obstacleGrid, memo);
}

int uniquePathsWithObstacles(int** obstacleGrid, int obstacleGridSize, int* obstacleGridColSize) {
    int m = obstacleGridSize, n = *obstacleGridColSize;
    int memo[m][n];
    memset(memo, -1, sizeof(memo));
    return dfs(m - 1, n - 1, m, n, obstacleGrid, memo);
}

int uniquePathsWithObstacles2(int** obstacleGrid, int obstacleGridSize, int* obstacleGridColSize) {
    int m = obstacleGridSize, n = *obstacleGridColSize;
    int f[m + 1][n + 1];
    memset(f, 0, sizeof(f));
    f[0][1] = 1;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 0) {
                f[i + 1][j + 1] = f[i][j + 1] + f[i + 1][j];
            }
        }
    }
    return f[m][n];
}

int uniquePathsWithObstacles3(int** obstacleGrid, int obstacleGridSize, int* obstacleGridColSize) {
    int m = obstacleGridSize, n = *obstacleGridColSize;
    int f[n + 1];
    memset(f, 0, sizeof(f));
    f[1] = 1;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 0) {
                f[j + 1] += f[j];
            } else {
                f[j + 1] = 0;
            }
        }
    }
    return f[n];
}