/**
 * 139. 单词拆分：https://leetcode.cn/problems/word-break
 */

#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

static bool dfs(char* s, int i, char** wordDict, int wordDictSize, int *dp);

// 记忆化搜索
bool wordBreak(char* s, char** wordDict, int wordDictSize) {
    int len = strlen(s);
    int *dp = malloc(sizeof(int) * len);
    memset(dp, -1, sizeof(int) * len);
    bool ans = dfs(s, 0, wordDict, wordDictSize, dp);
    free(dp);
    return ans;
}

static bool dfs(char* s, int i, char** wordDict, int wordDictSize, int *dp){
    if (s[i] == '\0') {
        return true;
    }
    if (dp[i] != -1) {
        return dp[i];
    }

    bool res = false;
    for (int j = 0; j < wordDictSize; j++) {
        char *word = wordDict[j];
        int k = 0;
        bool found = false;
        while (s[i + k] != '\0' && word[k] == s[i + k]) {
            k++;
            if (word[k] == '\0') {
                found = true;
                break;
            }
        }
        if (found) {
            res = dfs(s, i + k, wordDict, wordDictSize, dp);
        }
        if (res) {
            break;
        }
    }
    return dp[i] = res;
}

// 动态规划
bool wordBreak(char* s, char** wordDict, int wordDictSize) {
    int n = strlen(s);
    int *dp = calloc(n + 1, sizeof(int));
    dp[n] = true;

    for (int i = n - 1; i >= 0; i--) {
        bool res = false;
        for (int j = 0; j < wordDictSize; j++) {
            char *word = wordDict[j];
            int k = 0;
            bool found = false;
            while (s[i + k] != '\0' && word[k] == s[i + k]) {
                k++;
                if (word[k] == '\0') {
                    found = true;
                    break;
                }
            }
            if (found) {
                res = dp[i + k];
            }
            if (res) {
                break;
            }
        }
        dp[i] = res;
    }

    int res = dp[0];
    free(dp);
    return res;
}