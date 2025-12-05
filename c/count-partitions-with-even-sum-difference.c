/**
 * 3432. 统计元素和差值为偶数的分区方案：https://leetcode.cn/problems/count-partitions-with-even-sum-difference
 */

int countPartitions(int* nums, int numsSize) {
    int total = 0;
    for (int i = 0; i < numsSize; i++) {
        total += nums[i];
    }
    int ans = 0;
    int s = 0;
    for (int i = 0; i < numsSize - 1; i++) {
        s = s + nums[i];
        if (((total - s * 2) & 1) == 0) {
            ans++;
        }
    }
    return ans;
}