import java.util.ArrayDeque;
import java.util.Deque;

import static util.ArrayUtils.array;

/**
 * 2104. 子数组范围和：https://leetcode.cn/problems/sum-of-subarray-ranges/
 */
public class SumOfSubarrayRanges {

    public static long subArrayRanges(int[] nums) {
        long maxSum = sum(nums, false);
        long minSum = sum(nums, true);
        return maxSum - minSum;
    }

    private static long sum(int[] nums, boolean sumMin) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;
        for (int i = -1; i <= n; i++) {
            while (check(nums, i, stack, sumMin)) {
                int cur = stack.pop();
                int left = stack.peek(), right = i;
                sum += (cur - left) * (right - cur) * (long)nums[cur];
            }
            stack.push(i);
        }
        return sum;
    }

    private static boolean check(int[] nums, int index, Deque<Integer> stack, boolean sumMin) {
        if (stack.isEmpty()) {
            return false;
        }
        if (sumMin) {
            return getValue(nums, stack.peek(), Integer.MIN_VALUE) > getValue(nums, index, Integer.MIN_VALUE);
        } else {
            return getValue(nums, stack.peek(), Integer.MAX_VALUE) < getValue(nums, index, Integer.MAX_VALUE);
        }
    }

    private static int getValue(int[] nums, int index, int defaultValue) {
        return index == -1 || index == nums.length ? defaultValue : nums[index];
    }

    public static void main(String[] args) {
        System.out.println(subArrayRanges(array("[1,2,3]"))); // 4
        System.out.println(subArrayRanges(array("[1,3,3]"))); // 4
        System.out.println(subArrayRanges(array("[4,-2,-3,4,1]"))); // 59
    }

}
