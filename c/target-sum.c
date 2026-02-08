/**
 * 494. 目标和：https://leetcode.cn/problems/target-sum
 */

#include <stdlib.h>
#include <string.h>

int dfs(int* nums, int i, int target, int n, int memo[n][4001]) {
    if (i == n) {
        return target == 0 ? 1 : 0;
    }
    if (memo[i][target + 2000] != -1) {
        return memo[i][target + 2000];
    }
    return memo[i][target + 2000] = dfs(nums, i + 1, target - nums[i], n, memo) + dfs(nums, i + 1, target + nums[i], n, memo);
}

int findTargetSumWays(int* nums, int numsSize, int target) {
    int memo[numsSize][4001];
    memset(memo, -1, sizeof(memo));
    return dfs(nums, 0, target, numsSize, memo);
}

int dfs2(int* nums, int i, int target, int n, int lower, int upper, int memo[n][upper - lower + 1]) {
    if (i == n) {
        return target == 0 ? 1 : 0;
    }
    if (memo[i][target - lower] != -1) {
        return memo[i][target - lower];
    }
    return memo[i][target - lower] = dfs2(nums, i + 1, target - nums[i], n, lower, upper, memo) + dfs2(nums, i + 1, target + nums[i], n, lower, upper, memo);
}

int findTargetSumWays2(int* nums, int n, int target) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i];
    }
    int lower = target - sum;
    int upper = target + sum;
    int memo[n][upper - lower + 1];
    memset(memo, -1, sizeof(memo));
    return dfs2(nums, 0, target, n, lower, upper, memo);
}

#define MIN(a, b) ((a) < (b) ? (a) : (b))

int findTargetSumWays3(int* nums, int n, int target) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i];
    }
    if (abs(target) > sum) {
        return 0;
    }
    int lower = target - sum;
    int upper = target + sum;
    int f[n + 1][upper - lower + 1];
    memset(f, 0, sizeof(f));
    f[n][0 - lower] = 1;
    for (int i = n - 1; i >= 0; i--) {
        for (int x = lower + nums[i]; x <= upper - nums[i]; x++) {
            f[i][x - lower] = f[i + 1][x - nums[i] - lower] + f[i + 1][x + nums[i] - lower];
        }
    }
    return f[0][target - lower];
}

int findTargetSumWays4(int* nums, int n, int target) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i];
    }
    if (abs(target) > sum) {
        return 0;
    }
    int lower = target - sum;
    int upper = target + sum;
    int *f1 = calloc(upper - lower + 1, sizeof(int));
    int *f2 = calloc(upper - lower + 1, sizeof(int));
    f1[0 - lower] = 1;
    for (int i = n - 1; i >= 0; i--) {
        for (int x = lower + nums[i]; x <= upper - nums[i]; x++) {
            f2[x - lower] = f1[x - nums[i] - lower] + f1[x + nums[i] - lower];
        }
        int *tmp = f2;
        f2 = f1;
        f1 = tmp;
    }
    int ans = f1[target - lower];
    free(f1);
    free(f2);
    return ans;
}
