/**
 * 53. 最大子数组和：https://leetcode.cn/problems/maximum-subarray
 */

#include <limits.h>
#include <stdio.h>

#define MAX(a, b) (((a) > (b)) ? (a) : (b))

int maxSubArray(int* nums, int n) {
    int f = INT_MIN;
    int ans = INT_MIN;
    for (int i = 0; i < n; i++) {
        f = MAX(f, 0) + nums[i];
        ans = MAX(ans, f);
    }
    return ans;
}

int main() {
    int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
    printf("%d\n", maxSubArray(nums, sizeof(nums) / sizeof(int)));
}
