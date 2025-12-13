/**
 * 2320. 统计放置房子的方式数：https://leetcode.cn/problems/count-number-of-ways-to-place-houses
 */

#define MOD 1000000007

int countHousePlacements(int n) {
    int f[n + 1][2];
    f[0][0] = 1;
    f[0][1] = 0;
    for (int i = 1; i <= n; i++) {
        f[i][0] = (f[i - 1][0] + f[i - 1][1]) % MOD;
        f[i][1] = f[i - 1][0];
    }
    long long ans = (f[n][0] + f[n][1]) % MOD;
    ans = ans * ans % MOD;
    return ans;
}

int countHousePlacements2(int n) {
    long long f0 = 1, f1 = 0;
    for (int i = 1; i <= n; i++) {
        long long newF = (f0 + f1) % MOD;
        f1 = f0;
        f0 = newF;
    }
    long long ans = (f0 + f1) % MOD;
    ans = ans * ans % MOD;
    return ans;
}