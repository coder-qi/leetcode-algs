/**
 * 643. 子数组最大平均数 I：https://leetcode.cn/problems/maximum-average-subarray-i/
 */


#include <limits.h>
#include <math.h>

double findMaxAverage(int* nums, int numsSize, int k) {
    double maxSum = INT_MIN;
    int sum = 0;
    for (int i = 0; i < numsSize; i++) {
        sum += nums[i];
        if (i + 1 < k) {
            continue;
        }
        maxSum = fmax(maxSum, sum);
        sum -= nums[i - k + 1];
    }
    return maxSum / k;
}
