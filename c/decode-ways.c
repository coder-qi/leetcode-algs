/**
 * 91. 解码方法：https://leetcode.cn/problems/decode-ways
 */

#include <stdlib.h>
#include <string.h>

#define MAX(a, b) (((a) > (b)) ? (a) : (b))

int numDecodings(char* s) {
    if (s[0] == '0') {
        return 0;
    }
    int n = strlen(s);
    int *dp = calloc(n + 1, sizeof(int));
    dp[0] = dp[1] = 1;

    for (int i = 1; i < n; i++) {
        if (s[i] != '0') {
            dp[i + 1] = dp[i];
        }
        int x = (s[i - 1] - '0') * 10 + (s[i] - '0');
        if (x >= 10 && x <= 26) {
            dp[i + 1] += dp[i - 1];
        }

    }

    int ans = dp[n];
    free(dp);
    return ans;
}
