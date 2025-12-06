/**
 * 3578. 统计极差最大为 K 的分割方式数：https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k
 */

#include <stdlib.h>

#define MOD 1000000007

int countPartitions(int* nums, int n, int k) {
    int *maxQ = malloc(sizeof(int) * n);
    int *minQ = malloc(sizeof(int) * n);
    int *dp = malloc(sizeof(int) * (n + 1));

    int maxHead = 0, minHead = 0, maxTail = 0, minTail = 0;
    long long s = 0;
    dp[0] = 1;
    for (int i = 0, left = 0; i < n; i++) {
        s += dp[i];

        while (maxTail > maxHead && nums[i] >= nums[maxQ[maxTail - 1]]) {
            maxTail--;
        }
        maxQ[maxTail++] = i;

        while (minTail > minHead && nums[i] <= nums[minQ[minTail - 1]]) {
            minTail--;
        }
        minQ[minTail++] = i;

        while (nums[maxQ[maxHead]] - nums[minQ[minHead]] > k) {
            s -= dp[left];
            left++;
            if (maxQ[maxHead] < left) {
                maxHead++;
            }
            if (minQ[minHead] < left) {
                minHead++;
            }
        }

        dp[i + 1] = s % MOD;
    }

    int ans = dp[n];
    free(maxQ);
    free(minQ);
    free(dp);
    return ans;
}
