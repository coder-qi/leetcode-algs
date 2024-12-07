import java.util.Deque;
import java.util.LinkedList;

import static util.ArrayUtils.array;
import static util.ResourceUtils.loadTestcase;

/**
 * 907. 子数组的最小值之和：https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class SumOfSubarrayMinimums {

    static final int MOD = (int) (1e9 + 7);

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getValue(arr, stack.peek()) > getValue(arr, i)) {
                int cur = stack.pop();
                ans = (ans + (long)(cur - stack.peek()) * (i - cur) * arr[cur]) % MOD;
            }
            stack.push(i);
        }
        return (int) ans;
    }

    private static int getValue(int[] arr, int index) {
        return index == -1 || index == arr.length ? Integer.MIN_VALUE : arr[index];
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(array("[3,1,2,4]"))); // 17
        System.out.println(sumSubarrayMins(array("[11,81,94,43,3]"))); // 444
        System.out.println(sumSubarrayMins(array(loadTestcase("901-testcase-1.txt")))); // 508796209
    }

}
