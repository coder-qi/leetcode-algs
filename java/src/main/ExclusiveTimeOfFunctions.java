import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * 636. 函数的独占时间：https://leetcode.cn/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            exclusiveTime(2, asList("0:start:0","1:start:2","1:end:5","0:end:6"))));
        System.out.println(Arrays.toString(
            exclusiveTime(1, asList("0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"))));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] arr = log.split(":");
            if (stack.isEmpty() || "start".equals(arr[1])) {
                stack.push(new int[] {Integer.valueOf(arr[0]), Integer.valueOf(arr[2]), 0});
            } else {
                int[] prev = stack.pop();
                int id = Integer.valueOf(arr[0]);
                int interval = Integer.valueOf(arr[2]) - prev[1] + 1;
                ans[id] += interval + prev[2];
                if (!stack.isEmpty()) {
                    stack.peek()[2] -= interval;
                }
            }
        }
        return ans;
    }

}
