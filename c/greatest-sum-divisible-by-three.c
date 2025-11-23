/**
 * 1262. 可被三整除的最大和：https://leetcode.cn/problems/greatest-sum-divisible-by-three
 */

#include <limits.h>
#include <math.h>

int maxSumDivThree(int* nums, int n) {
    int dp[2][3] = {0};
    dp[0][1] = dp[0][2] = INT_MIN;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
            dp[(i + 1) % 2][j] = fmax(dp[i % 2][j], dp[i % 2][(j + nums[i]) % 3] + nums[i]);
        }
    }
    return dp[n % 2][0];
}
