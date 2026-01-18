/**
 * 2267. 检查是否有合法括号字符串路径：https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path
 */

#include <stdbool.h>
#include <stdio.h>
#include <string.h>


bool dfs(char** grid, int i, int j, int k, int m, int n, int memo[m][n][(m + n + 1) / 2]) {
    if (i < 0 || j < 0 || k < 0 || k > i + j + 1) {
        return false;
    }
    int newK = k + (grid[i][j] == ')' ? 1 : -1);
    if (newK < 0) {
        return false;
    }
    if (i == 0 && j == 0) {
        return newK == 0;
    }
    if (memo[i][j][k] != -1) {
        return memo[i][j][k];
    }
    return memo[i][j][k] = dfs(grid, i - 1, j, newK, m, n, memo) || dfs(grid, i, j - 1, newK, m, n, memo);
}

bool hasValidPath(char** grid, int gridSize, int* gridColSize) {
    int m = gridSize;
    int n = *gridColSize;
    if ((m + n - 1) % 2 != 0 || grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
        return false;
    }
    int memo[m][n][(m + n + 1) / 2];
    memset(memo, -1, sizeof(memo));
    return dfs(grid, m - 1, n - 1, 0, m, n, memo);
}

