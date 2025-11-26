/**
 * 2435. 矩阵中和能被 K 整除的路径：https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k
 */

#include <stdlib.h>
#include <string.h>

#define MOD 1000000007

int numberOfPaths(int** grid, int gridSize, int* gridColSize, int k) {
    int m = gridSize;
    int n = *gridColSize;
    int** dp = calloc(n + 1, sizeof(int*));
    int* temp = calloc(k + 1, sizeof(int));
    for (int i = 0; i <= n; i++) {
        dp[i] = calloc(k + 1, sizeof(int));
    }
    dp[n - 1][0] = 1;
    for (int i = m - 1; i >= 0; --i) {
        for (int j = n - 1; j >= 0; --j) {
            for (int s = 0; s <= k; ++s) {
                const int x = (s + grid[i][j]) % k;
                temp[s] = (dp[j][x] + dp[j + 1][x]) % MOD;
            }
            memcpy(dp[j], temp, sizeof(int) * (k + 1));
        }
    }
    const int ans = dp[0][k];
    free(temp);
    free(dp);
    return ans;
}
