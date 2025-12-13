/**
 * 213. 打家劫舍 II：https://leetcode.cn/problems/house-robber-ii
 */

#include <stdio.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int rob1(int* nums, int start, int end) {
    int f0 = 0, f1 = 0;
    for (int i = start; i <= end; i++) {
        int f = MAX(nums[i] + f0, f1);
        f0 = f1;
        f1 = f;
    }
    return f1;
}

int rob(int* nums, int n) {
    return MAX(nums[0] + rob1(nums, 2, n - 2), rob1(nums, 1, n - 1));
}

int main(int argc, char *argv[]) {
    int nums[] = {2,3,2};
    printf("%d\n", rob(nums, 3));
    int nums2[] = {1,2,3,1};
    printf("%d\n", rob(nums2, 4));
    int nums3[] = {1,2,3};
    printf("%d\n", rob(nums3, 3));
}
