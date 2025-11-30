/**
 * 974. 和可被 K 整除的子数组：https://leetcode.cn/problems/subarray-sums-divisible-by-k
 */

#include <stdlib.h>

int subarraysDivByK(int* nums, int numsSize, int k) {
    int *count = calloc(k, sizeof(int));
    int ans = 0;
    int s = 0;
    for (int i = 0; i < numsSize; i++) {
        count[s]++;
        s = (s + nums[i] % k + k) % k;
        ans += count[s];
    }
    free(count);
    return ans;
}
