/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目：https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold
 */

int numOfSubarrays(int* arr, int arrSize, int k, int threshold) {
    int sum = 0;
    int ans = 0;
    for(int i = 0; i < arrSize; i++) {
        sum += arr[i];
        if (i + 1 < k) {
            continue;
        }
        if ((double)sum / k >= threshold) {
            ans++;
        }
        sum -= arr[i - k + 1];
    }
    return ans;
}