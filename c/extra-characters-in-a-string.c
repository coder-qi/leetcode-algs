/**
 * 2707. 字符串中的额外字符：https://leetcode.cn/problems/extra-characters-in-a-string
 */

#include <stdlib.h>
#include <string.h>

#define MIN(a,b) (((a)<(b))?(a):(b))

int minExtraChar(char *s, char **dictionary, int dictionarySize) {
    int n = strlen(s);
    int *workLen = malloc(sizeof(int) * dictionarySize);
    for (int i = 0; i < dictionarySize; i++) {
        workLen[i] = strlen(dictionary[i]);
    }

    int *dp = malloc(sizeof(int) * (n + 1));
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
        dp[i + 1] = dp[i] + 1;
        for (int j = 0; j < dictionarySize; j++) {
            char *word = dictionary[j];
            int wl = workLen[j];
            if (i + 1 >= wl && strncmp(s + i + 1 - wl, word, wl) == 0) {
                dp[i + 1] = MIN(dp[i + 1], dp[i + 1 - wl]);
            }
        }
    }

    int ans = dp[n];
    free(workLen);
    free(dp);
    return ans;
}
