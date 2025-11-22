/**
 * 3190. 使所有元素都可以被 3 整除的最少操作数：https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
 */

int minimumOperations(int* nums, int numsSize) {
    int ans = 0;
    for (int i = 0; i < numsSize; ++i) {
        if (nums[i] % 3 != 0) {
            ans++;
        }
    }
    return ans;
}