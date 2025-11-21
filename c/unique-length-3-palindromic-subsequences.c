/**
 * 1930. 长度为 3 的不同回文子序列：https://leetcode.cn/problems/unique-length-3-palindromic-subsequences
 */
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int countPalindromicSubsequence(char* s) {
    int len = strlen(s);
    int leftCount[26] = {0};
    int rightCount[26] = {0};
    for (int i = 1; i < len; i++) {
        rightCount[s[i] - 'a']++;
    }
    int ans = 0;
    int visited[26] = {0};
    for (int i = 1; i < len - 1; i++) {
        leftCount[s[i - 1] - 'a']++;
        rightCount[s[i] - 'a']--;
        for (int j = 0; j < 26; j++) {
            if (leftCount[j] && rightCount[j] && !(visited[s[i] - 'a'] & (1 << j))) {
                visited[s[i] - 'a'] |= (1 << j);
                ans++;
            }
        }
    }
    return ans;
}