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
        int[] left = new int[n]; // 每个元素辐射的左边界
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        int[] right = new int[n]; // 每个元素辐射的右边界
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(array("[3,1,2,4]"))); // 17
        System.out.println(sumSubarrayMins(array("[11,81,94,43,3]"))); // 444
        System.out.println(sumSubarrayMins(array(loadTestcase("901-testcase-1.txt")))); // 508796209
    }

}
