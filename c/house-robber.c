/**
 * 198. 打家劫舍：https://leetcode.cn/problems/house-robber
 */

#include <stdio.h>
#include <stdlib.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int rob(int* nums, int n) {
    int *f = malloc(sizeof(int) * (n + 2));
    f[0] = f[1] = 0;
    for (int i = 2; i <= n + 1; i++) {
        f[i] = MAX(nums[i - 2] + f[i - 2], f[i - 1]);
    }
    int ans = f[n + 1];
    free(f);
    return ans;
}

int rob2(int* nums, int n) {
    int f0 = 0, f1 = 0;
    for (int i = 2; i <= n + 1; i++) {
        int f = MAX(nums[i - 2] + f0, f1);
        f0 = f1;
        f1 = f;
    }
    return f1;
}

int dfs(int* nums, int i) {
    if (i < 0) {
        return 0;
    }
    return MAX(nums[i] + dfs(nums, i - 2), dfs(nums, i - 1));
}

int main(int argc, char *argv[]) {
    int nums[] = {1,2,3,1};
    printf("%d\n", dfs(nums, 3));
    printf("%d\n", rob(nums, 4));
    int nums2[] = {2,7,9,3,1};
    printf("%d\n", dfs(nums2, 4));
    printf("%d\n", rob(nums2, 5));
}
