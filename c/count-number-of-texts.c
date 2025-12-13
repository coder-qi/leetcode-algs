/**
 * 2266. 统计打字方案数：https://leetcode.cn/problems/count-number-of-texts
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MOD 1000000007

int countTexts(char* pressedKeys) {
    int n = strlen(pressedKeys);
    int *f = malloc(sizeof (int) * (n + 1));
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
        char c = pressedKeys[i - 1];
        int k = c == '7' || c == '9' ? 4 : 3;
        long long res = 0;
        for (int j = 0; j < k && i - j - 1 >= 0 && pressedKeys[i - j - 1] == c; j++) {
            res += f[i - j - 1];
        }
        f[i] = res % MOD;
    }

    int ans = f[n];
    free(f);
    return ans;
}

int countTexts2(char* pressedKeys) {
    int n = strlen(pressedKeys);
    int f[4];
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
        char c = pressedKeys[i - 1];
        int k = c == '7' || c == '9' ? 4 : 3;
        long long res = 0;
        for (int j = 0; j < k && i - j - 1 >= 0 && pressedKeys[i - j - 1] == c; j++) {
            res += f[(i - j - 1) % 4];
        }
        f[i % 4] = res % MOD;
    }
    return f[n % 4];
}

int dfs(char* pressedKeys, int i) {
    if (i < 0) {
        return 1;
    }
    char c = pressedKeys[i];
    int k = c == '7' || c == '9' ? 4 : 3;
    long long res = 0;
    for (int j = 0; j < k && i - j >= 0 && pressedKeys[i - j] == c; ++j) {
        res += dfs(pressedKeys, i - j - 1);
    }
    return res % MOD;
}

int main(int argc, char *argv[]) {
    printf("%d\n", countTexts2("22233"));
}
