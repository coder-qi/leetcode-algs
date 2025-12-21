/**
 * 64. 最小路径和：https://leetcode.cn/problems/minimum-path-sum
 */

#include <limits.h>
#include <string.h>

#define MIN(a,b) (((a)<(b))?(a):(b))

int dfs(int **grid, int i, int j, int m, int n, int mem[m][n]) {
    if (i >= m || j >= n) {
        return i == m && j == n - 1 ? 0 : INT_MAX / 2;
    }
    if (mem[i][j] != -1) {
        return mem[i][j];
    }
    return mem[i][j] = grid[i][j] + MIN(dfs(grid, i + 1, j, m, n, mem), dfs(grid, i, j + 1, m, n, mem));
}

int minPathSum(int **grid, int gridSize, int *gridColSize) {
    int mem[gridSize][*gridColSize];
    memset(mem, -1, sizeof(mem));
    return dfs(grid, 0, 0, gridSize, *gridColSize, mem);
}

int minPathSum2(int **grid, int gridSize, int *gridColSize) {
    int f[gridSize + 1][*gridColSize + 1];
    for (int i = 0; i < gridSize; i++) {
        f[i][*gridColSize] = INT_MAX / 2;
    }
    for (int i = 0; i < *gridColSize; i++) {
        f[gridSize][i] = INT_MAX / 2;
    }
    f[gridSize][*gridColSize - 1] = 0;
    for (int i = gridSize - 1; i >= 0; i--) {
        for (int j = *gridColSize - 1; j >= 0; j--) {
            f[i][j] = grid[i][j] + MIN(f[i + 1][j], f[i][j + 1]);
        }
    }
    return f[0][0];
}

int minPathSum3(int **grid, int gridSize, int *gridColSize) {
    int f[2][*gridColSize + 1];
    for (int i = 0; i <= *gridColSize; i++) {
        f[0][i] = f[1][i] = INT_MAX / 2;
    }
    f[gridSize % 2][*gridColSize - 1] = 0;
    for (int i = gridSize - 1; i >= 0; i--) {
        for (int j = *gridColSize - 1; j >= 0; j--) {
            f[i % 2][j] = grid[i][j] + MIN(f[(i + 1) % 2][j], f[i % 2][j + 1]);
        }
    }
    return f[0][0];
}

int minPathSum4(int **grid, int gridSize, int *gridColSize) {
    int f[*gridColSize + 1];
    for (int i = 0; i <= *gridColSize; i++) {
        f[i] = INT_MAX / 2;
    }
    f[*gridColSize - 1] = 0;
    for (int i = gridSize - 1; i >= 0; i--) {
        for (int j = *gridColSize - 1; j >= 0; j--) {
            f[j] = grid[i][j] + MIN(f[j], f[j + 1]);
        }
    }
    return f[0];
}