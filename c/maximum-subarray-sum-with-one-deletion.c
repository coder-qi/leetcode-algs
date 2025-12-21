/**
 * 1186. 删除一次得到子数组最大和：https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion
 */

#include <limits.h>
#include <stdbool.h>

#define MAX(a,b) (((a)>(b))?(a):(b))

int dfs(int* arr, int i, bool deleted, int mem[][2]) {
    if (i < 0) {
        return INT_MIN / 2;
    }
    if (mem[i][deleted] != INT_MIN) {
        return mem[i][deleted];
    }
    if (deleted) {
        return mem[i][deleted] = arr[i] + MAX(dfs(arr, i - 1, deleted, mem), 0);
    }
    return mem[i][deleted] = MAX(dfs(arr, i - 1, deleted, mem) + arr[i], dfs(arr, i - 1, true, mem));
}

int maximumSum(int* arr, int n) {
    int mem[n][2];
    for (int i = 0; i < n; i++) {
        mem[i][0] = mem[i][1] = INT_MIN;
    }
    int ans = INT_MIN;
    for (int i = 0; i < n; i++) {
        ans = MAX(ans, MAX(dfs(arr, i, false, mem), dfs(arr, i, true, mem)));
    }
    return ans;
}

int maximumSum2(int* arr, int n) {
    int f[n + 1][2];
    f[0][0] = f[0][1] = INT_MIN / 2;
    int ans = INT_MIN;
    for (int i = 0; i < n; i++) {
        f[i + 1][1] = arr[i] + MAX(f[i][1], 0);
        f[i + 1][0] = MAX(arr[i] + f[i][0], f[i][1]);
        ans = MAX(ans, MAX(f[i + 1][1], f[i + 1][0]));
    }
    return ans;
}

int maximumSum3(int* arr, int n) {
    int f0 = INT_MIN / 2, f1 = INT_MIN / 2;
    int ans = INT_MIN;
    for (int i = 0; i < n; i++) {
        f0 = MAX(arr[i] + f0, f1);
        f1 = arr[i] + MAX(f1, 0);
        ans = MAX(ans, MAX(f0, f1));
    }
    return ans;
}