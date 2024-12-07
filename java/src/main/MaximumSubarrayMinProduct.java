import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import util.ArrayUtils;

import static util.ArrayUtils.array;

/**
 * 1856. 子数组最小乘积的最大值：https://leetcode.cn/problems/maximum-subarray-min-product/
 */
public class MaximumSubarrayMinProduct {

    static final int MOD = (int) (1e9 + 7);

    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getValue(nums, stack.peek()) > getValue(nums, i)) {
                int cur = stack.pop();
                int left = stack.peek(), right = i - 1;
                long product = nums[cur] * (sum[right] - (left != -1 ? sum[left] : 0));
                ans = Math.max(ans, product);
            }
            stack.push(i);
        }
        ans %= MOD;
        return (int) ans;
    }

    private static int getValue(int[] nums, int index) {
        return index == -1 || index == nums.length ? Integer.MIN_VALUE : nums[index];
    }

    public static void main(String[] args) {
        System.out.println(maxSumMinProduct(array("[1,2,3,2]"))); // 14
        System.out.println(maxSumMinProduct(array("[2,3,3,1,2]"))); // 18
        System.out.println(maxSumMinProduct(array("[3,1,5,6,4,2]"))); // 60
    }

}
