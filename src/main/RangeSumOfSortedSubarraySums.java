import java.util.Arrays;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 1508. 子数组和排序后的区间和：https://leetcode.cn/problems/range-sum-of-sorted-subarray-sums/
 */
public class RangeSumOfSortedSubarraySums {

    static final int MOD = (int) (1e9 + 7);

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        for (int i = 0, k = 0; i < n; i++) {
            int s = 0;
            for (int j = i; j < n; j++) {
                s += nums[j];
                sums[k++] = s;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rangeSum(array("[1,2,3,4]"), 4, 1, 5)); // 13
        System.out.println(rangeSum(array("[1,2,3,4]"), 4, 3, 4)); // 6
        System.out.println(rangeSum(array(loadTestcase("1508-testcase-1.txt")), 1000, 1, 500500)); // 716699888
    }

}
