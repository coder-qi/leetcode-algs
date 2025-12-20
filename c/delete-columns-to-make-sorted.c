/**
 * 944. 删列造序：https://leetcode.cn/problems/delete-columns-to-make-sorted
 */

#include <string.h>

int minDeletionSize(char** strs, int n) {
    int m = strlen(strs[0]);
    int ans = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = 1; j < n; ++j) {
            if (strs[j][i] < strs[j - 1][i] ) {
                ans++;
                break;
            }
        }
    }
    return ans;
}
