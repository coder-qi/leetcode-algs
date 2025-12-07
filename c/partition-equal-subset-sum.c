/**
 * 416. 分割等和子集：https://leetcode.cn/problems/partition-equal-subset-sum
 */

#include <stdbool.h>
#include <stdlib.h>

#define MIN(a, b) ((b) < (a) ? (b) : (a))

bool canPartition(int* nums, int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i];
    }
    if (sum & 1) {
        return false;
    }
    int k = sum >> 1;
    bool * dp = calloc(k + 1, sizeof(bool));
    dp[0] = true;
    int s = 0;
    for (int i = 0; i < n; i++) {
        int num = nums[i];
        s = MIN(s + num, k);
        for (int j = s; j >= num; j--) {
            dp[j] |= dp[j - num];
        }
        if (dp[k]) {
            free(dp);
            return true;
        }
    }
    free(dp);
    return false;
}
