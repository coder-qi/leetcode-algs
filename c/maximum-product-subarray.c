/**
 * 152. 乘积最大子数组：https://leetcode.cn/problems/maximum-product-subarray
 */

#define MIN(a,b) (((a)<(b))?(a):(b))
#define MAX(a,b) (((a)>(b))?(a):(b))

int maxProduct(int* nums, int n) {
    int max = nums[0];
    int min = nums[0];
    int ans = nums[0];
    for (int i = 1; i < n; i++) {
        int newMin = MIN(min * nums[i], MIN(max * nums[i], nums[i]));
        int newMax = MAX(max * nums[i], MAX(min * nums[i], nums[i]));
        ans = MAX(ans, newMax);
        min = newMin;
        max = newMax;
    }
    return ans;
}
