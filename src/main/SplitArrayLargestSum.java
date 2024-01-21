import java.util.Arrays;

/**
 * 410. 分割数组的最大值：https://leetcode.cn/problems/split-array-largest-sum/description/
 */
public class SplitArrayLargestSum {

    int[] preSum;
    int n;
    int[][] mem;

    public int splitArray(int[] nums, int k) {
        n = nums.length;
        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        mem = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return process(0, k);
    }

    private int process(int index, int k) {
        if (k == 1) {
            return preSum[n] - preSum[index];
        }
        if (mem[index][k] != -1) {
            return mem[index][k];
        }
        int res = Integer.MAX_VALUE;
        for (int i = index; i < n - k + 1; i++) {
            int p = process(i + 1, k - 1);
            res = Math.min(res, Math.max(p, preSum[i + 1] - preSum[index]));
        }
        return mem[index][k] = res;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {7,2,5,10,8}, 2)); // 18
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,2,3,4,5}, 2)); // 9
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1,4,4}, 3)); // 4
    }

}
