/**
 * 66. 加一：https://leetcode.cn/problems/plus-one
 */

#include <stdbool.h>
#include <stdlib.h>

int* plusOne(int* digits, int digitsSize, int* returnSize) {
    digits[digitsSize-1]++;
    for(int i = digitsSize - 1; i > 0; i--) {
        if (digits[i] == 10) {
            digits[i] = 0;
            digits[i - 1]++;
        }
    }
    if (digits[0] == 10) {
        int * res = calloc(digitsSize + 1, sizeof(int));
        res[0] = 1;
        *returnSize = digitsSize + 1;
        return res;
    }
    *returnSize = digitsSize;
    return digits;
}
