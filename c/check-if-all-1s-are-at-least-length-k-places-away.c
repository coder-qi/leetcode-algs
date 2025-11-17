/**
 * 1437. 是否所有 1 都至少相隔 k 个元素：https://leetcode.cn/problems/check-if-all-1s-are-at-least-length-k-places-away
 */
#include <stdbool.h>

bool kLengthApart(int *nums, int numsSize, int k) {
    int last = -1;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == 1) {
            if (last != -1 && i - last -1 < k) {
                return false;
            }
            last = i;
        }
    }
    return true;
}
