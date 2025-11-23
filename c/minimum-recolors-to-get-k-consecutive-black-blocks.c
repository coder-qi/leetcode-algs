/**
 * 2379. 得到 K 个黑块的最少涂色次数：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 */

#include <limits.h>
#include <math.h>

int minimumRecolors(char *blocks, int k) {
    int ans = INT_MAX;
    int count = 0;
    for (char *p = blocks, *q = p; *p; p++) {
        if (*p == 'W') {
            count++;
        }
        if (p - blocks + 1 < k) {
            continue;
        }
        ans = fmin(ans, count);
        if (*q == 'W') {
            count--;
        }
        q++;
    }
    return ans;
}
