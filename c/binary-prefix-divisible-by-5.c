/**
 * 1018. 可被 5 整除的二进制前缀：https://leetcode.cn/problems/binary-prefix-divisible-by-5
 */

#include <stdbool.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool* prefixesDivBy5(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize;
    bool* prefixes = malloc(sizeof(bool) * numsSize);

    int x = 0;
    for (int i = 0; i < numsSize; i++) {
        x = ((x << 1) | nums[i]) % 5;
        prefixes[i] = x == 0;
    }
    return prefixes;
}