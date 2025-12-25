/**
 * 120. 三角形最小路径和：https://leetcode.cn/problems/triangle/
 */

#include <limits.h>
#include <string.h>

#define MIN(a,b) (((a)<(b))?(a):(b))

int dfs(int **triangle, int i, int j, int m, int memo[m][m]) {
    if (i == m) {
        return 0;
    }
    if (memo[i][j] != INT_MAX) {
        return memo[i][j];
    }
    return memo[i][j] = triangle[i][j] + MIN(dfs(triangle, i + 1, j, m, memo), dfs(triangle, i + 1, j + 1, m, memo));
}

int minimumTotal(int **triangle, int triangleSize, int *triangleColSize) {
    int memo[triangleSize][triangleSize];
    for (int i = 0; i < triangleSize; i++) {
        for (int j = 0; j < triangleSize; j++) {
            memo[i][j] = INT_MAX;
        }
    }
    return dfs(triangle, 0, 0, triangleSize, memo);
}

int minimumTotal2(int **triangle, int triangleSize, int *triangleColSize) {
    int f[triangleSize + 1][triangleSize + 1];
    memset(f, 0, sizeof(f));
    for (int i = triangleSize - 1; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            f[i][j] = triangle[i][j] + MIN(f[i + 1][j], f[i + 1][j + 1]);
        }
    }
    return f[0][0];
}

int minimumTotal3(int **triangle, int triangleSize, int *triangleColSize) {
    int f[triangleSize + 1];
    memset(f, 0, sizeof(f));
    for (int i = triangleSize - 1; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            f[j] = triangle[i][j] + MIN(f[j], f[j + 1]);
        }
    }
    return f[0];
}