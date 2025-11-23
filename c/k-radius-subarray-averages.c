#include <stdlib.h>
#include <string.h>
/**
 * 2090. 半径为 k 的子数组平均值：https://leetcode.cn/problems/k-radius-subarray-averages
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getAverages(int* nums, int numsSize, int k, int* returnSize) {
    *returnSize = numsSize;
    int* ans = malloc(numsSize * sizeof(int));
    memset(ans, -1, numsSize * sizeof(int));
    long long sum = 0;
    for (int i = 0; i < numsSize; i++) {
        sum += nums[i];
        if (i < 2 * k) {
            continue;
        }
        ans[i - k] = sum / (2 * k + 1);
        sum -= nums[i - 2 * k];
    }
    return ans;
}