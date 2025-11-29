/**
 * 3512. 使数组和能被 K 整除的最少操作次数：https://leetcode.cn/problems/minimum-operations-to-make-array-sum-divisible-by-k
 */

int minOperations(int* nums, int numsSize, int k) {
    int sum = 0;
    for(int i = 0; i < numsSize; i++) {
        sum += nums[i];
    }
    return sum % k;
}