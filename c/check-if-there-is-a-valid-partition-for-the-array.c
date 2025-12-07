/**
 * 2369. 检查数组是否存在有效划分：https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array
 */


#include <stdbool.h>
#include <stdlib.h>

bool validPartition(int *nums, int n) {
    bool *dp = calloc(n + 1, sizeof(bool));
    dp[0] = true;
    for (int i = 1; i < n; i++) {
        if ((dp[i - 1] && nums[i] == nums[i - 1]) ||
            (i > 1 && dp[i - 2] &&
                ((nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) ||
                (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)))) {
            dp[i + 1] = true;
        }
    }
    int ans = dp[n];
    free(dp);
    return ans;
}
