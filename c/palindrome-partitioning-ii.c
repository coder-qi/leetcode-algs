/**
 *  132. 分割回文串 II：https://leetcode.cn/problems/palindrome-partitioning-ii
 */

#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

#define MIN(a,b) (((a)<(b))?(a):(b))

static bool isPalindrome(char *s, int left, int right, int **palindromeMemo) {
    if (left >= right) {
        return true;
    }
    if (palindromeMemo[left][right] != -1) {
        return palindromeMemo[left][right];
    }
    bool res = s[left] == s[right] ? isPalindrome(s, left + 1, right - 1, palindromeMemo) : false;
    palindromeMemo[left][right] = res;
    return res;
}

static int dfs(char *s, int right, int n, int *dfsMemo, int **palindromeMemo) {
    if (isPalindrome(s, 0, right, palindromeMemo)) {
        return 0;
    }
    if (dfsMemo[right] != -1) {
        return dfsMemo[right];
    }
    int res = INT_MAX;
    for (int left = 1; left <= right; left++) {
        if (isPalindrome(s, left, right, palindromeMemo)) {
            res = MIN(res, dfs(s, left - 1, n, dfsMemo, palindromeMemo) + 1);
        }
    }
    return dfsMemo[right] = res;
}

int minCut(char *s) {
    int n = strlen(s);
    int *dfsMemo = malloc(sizeof(int) * n);
    memset(dfsMemo, -1, sizeof(int) * n);

    int **palindromeMemo = malloc(sizeof(int *) * n);
    for (int i = 0; i < n; i++) {
        palindromeMemo[i] = malloc(sizeof(int) * n);
        memset(palindromeMemo[i], -1, sizeof(int) * n);
    }

    int ans = dfs(s, 0, n, dfsMemo, palindromeMemo);

    free(dfsMemo);
    for (int i = 0; i < n; i++) {
        free(palindromeMemo[i]);
    }
    free(palindromeMemo);
    return ans;
}

int minCut2(char *s) {
    int n = strlen(s);

    bool **palindromeDp = malloc(sizeof(bool *) * n);
    for (int i = 0; i < n; i++) {
        palindromeDp[i] = malloc(sizeof(bool) * n);
    }
    palindromeDp[0][0] = true;
    for (int i = 1; i < n; i++) {
        palindromeDp[i][i] = palindromeDp[i][i - 1] = true;
    }
    for (int i = n - 2; i >= 0; i--) {
        for (int j = i + 1; j < n; j++) {
            palindromeDp[i][j] = s[i] == s[j] && palindromeDp[i + 1][j - 1];
        }
    }

    int *dp = calloc(n, sizeof(int));
    for (int right = 0; right < n; right++) {
        if (palindromeDp[0][right]) {
            continue;
        }
        int res = INT_MAX;
        for (int left = 1; left <= right; left++) {
            if (palindromeDp[left][right]) {
                res = MIN(res, dp[left - 1] + 1);
            }
        }
        dp[right] = res;
    }
    int ans = dp[n - 1];

    free(dp);
    for (int i = 0; i < n; i++) {
        free(palindromeDp[i]);
    }
    free(palindromeDp);
    return ans;
}
