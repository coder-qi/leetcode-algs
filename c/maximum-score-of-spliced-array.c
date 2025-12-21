/**
 * 2321. 拼接数组的最大分数：https://leetcode.cn/problems/maximum-score-of-spliced-array
 */

#define MAX(a,b) (((a)>(b))?(a):(b))

int maximumsSplicedArray(int *nums1, int nums1Size, int *nums2, int nums2Size) {
    int sum1 = 0, sum2 = 0;
    int maxF1 = 0, maxF2 = 0;
    int maxS1 = 0, maxS2 = 0;
    for (int i = 0; i < nums1Size; i++) {
        sum1 += nums1[i];
        sum2 += nums2[i];
        maxF1 = MAX(maxF1 + nums2[i] - nums1[i], 0);
        maxS1 = MAX(maxS1, maxF1);
        maxF2 = MAX(maxF2 + nums1[i] - nums2[i], 0);
        maxS2 = MAX(maxS2, maxF2);
    }
    return MAX(sum1 + maxS1, sum2 + maxS2);
}
