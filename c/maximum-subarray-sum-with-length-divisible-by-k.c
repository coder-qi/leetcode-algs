/**
 * 3381. 长度可被 K 整除的子数组的最大元素和：https://leetcode.cn/problems/maximum-subarray-sum-with-length-divisible-by-k
 */

#include <limits.h>
#include <string.h>

#define MAX(a,b) (((a)>(b))?(a):(b))

long long dfs(int* nums, int i, int k, int n, long long* memo, long long* preSum) {
    if (i < 0 || i + 1 < k) {
        return LLONG_MIN / 2;
    }
    if (memo[i] != LLONG_MIN) {
        return memo[i];
    }
    long long sum = preSum[i + 1] - preSum[i - k + 1];
    return memo[i] = sum + MAX(0, dfs(nums, i - k, k, n, memo, preSum));
}

long long maxSubarraySum(int* nums, int n, int k) {
    long long memo[n];
    long long preSum[n + 1];
    preSum[0] = 0;
    for (int i = 0; i < n; i++) {
        memo[i] = LLONG_MIN;
        preSum[i + 1] = preSum[i] + nums[i];
    }
    long long ans = LLONG_MIN;
    for (int i = 0; i < n; i++) {
        ans = MAX(ans, dfs(nums, i, k, n, memo, preSum));
    }
    return ans;
}

long long maxSubarraySum2(int* nums, int n, int k) {
    long long preSum[n + 1];
    preSum[0] = 0;
    for (int i = 0; i < n; i++) {
        preSum[i + 1] = preSum[i] + nums[i];
    }
    long long f[n + 1];
    for (int i = 0; i < k; ++i) {
        f[i] = LLONG_MIN / 2;
    }

    long long ans = LLONG_MIN;
    for (int i = k - 1; i < n; i++) {
        f[i + 1] = preSum[i + 1] - preSum[i - k + 1] + MAX(0, f[i - k + 1]);
        ans = MAX(ans, f[i + 1]);
    }
    return ans;
}

long long maxSubarraySum3(int* nums, int n, int k) {
    long long preSum[n + 1];
    preSum[0] = 0;
    long long f[n + 1];
    for (int i = 0; i < k; ++i) {
        f[i] = LLONG_MIN / 2;
        preSum[i + 1] = preSum[i] + nums[i];
    }

    long long ans = LLONG_MIN;
    for (int i = k - 1; i < n; i++) {
        preSum[i + 1] = preSum[i] + nums[i];
        f[i + 1] = preSum[i + 1] - preSum[i - k + 1] + MAX(0, f[i - k + 1]);
        ans = MAX(ans, f[i + 1]);
    }
    return ans;
}

long long maxSubarraySum4(int* nums, int n, int k) {
    long long f[k];
    long long preSum[k + 1];
    preSum[0] = 0;
    for (int i = 0; i < k; ++i) {
        f[i] = LLONG_MIN / 2;
        preSum[i + 1] = preSum[i] + nums[i];
    }

    long long ans = LLONG_MIN;
    for (int i = k - 1; i < n; i++) {
        preSum[(i + 1) % (k + 1)] = preSum[i % (k + 1)] + nums[i];
        f[(i + 1) % k] = preSum[(i + 1) % (k + 1)] - preSum[(i - k + 1) % (k + 1)] + MAX(0, f[(i - k + 1) % k]);
        ans = MAX(ans, f[(i + 1) % k]);
    }
    return ans;
}