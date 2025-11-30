/**
 * 2575. 找出字符串的可整除数组：https://leetcode.cn/problems/find-the-divisibility-array-of-a-string
 */

#include <stdlib.h>
#include <string.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* divisibilityArray(char* word, int m, int* returnSize) {
    int n = strlen(word);
    *returnSize = n;
    int* div = calloc(n, sizeof(int));
    long long x = 0;
    for (int i = 0; i < n; i++) {
        x = (x * 10 + word[i] - '0') % m;
        div[i] = x == 0;
    }
    return div;
}