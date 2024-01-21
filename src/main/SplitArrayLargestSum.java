/**
 * 410. 分割数组的最大值：https://leetcode.cn/problems/split-array-largest-sum/description/
 */
public class SplitArrayLargestSum {

    int res = Integer.MAX_VALUE;
    int[] preSum;
    int n;

    public int splitArray(int[] nums, int k) {
        n = nums.length;
        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        process(0, k, 0);
        return res;
    }

    private void process(int index, int k, int maxSum) {
        if (k == 1) {
            maxSum = Math.max(maxSum, preSum[n] - preSum[index]);
            res = Math.min(res, maxSum);
            return;
        }
        for (int i = index; i < n - k + 1; i++) {
            process(i + 1, k - 1, Math.max(maxSum, preSum[i + 1] - preSum[index]));
        }
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {7,2,5,10,8}, 2)); // 18
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,2,3,4,5}, 2)); // 9
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,4,4}, 3)); // 4
    }

}
