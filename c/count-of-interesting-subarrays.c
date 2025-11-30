/**
 * 2845. 统计趣味子数组的数目：https://leetcode.cn/problems/count-of-interesting-subarrays
 */

#include <stdlib.h>

#define MIN(a,b) (((a)<(b))?(a):(b))

long long countInterestingSubarrays(int *nums, int n, int modulo, int k) {
    int *cnt = calloc(MIN(n + 1, modulo), sizeof(int));
    int s = 0;
    long long ans = 0;
    cnt[0] = 1;
    for (int i = 0; i < n; i++) {
        if (nums[i] % modulo == k) {
            s++;
        }
        if (s >= k) {
            ans += cnt[(s - k) % modulo];
        }
        cnt[s % modulo]++;
    }
    free(cnt);
    return ans;
}
