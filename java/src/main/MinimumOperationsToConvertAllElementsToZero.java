import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3542. 将所有元素变为 0 的最少操作次数：https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero
 */
public class MinimumOperationsToConvertAllElementsToZero {

    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int num : nums) {
            int prevNum = -1;
            while (!stack.isEmpty() && num < stack.peek()) {
                if (prevNum != stack.peek()) {
                    ans++;
                }
                prevNum = stack.pop();
            }
            stack.push(num);
        }
        int prevNum = -1;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (prevNum != num && num != 0) {
                ans++;
            }
            prevNum = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumOperationsToConvertAllElementsToZero app = new MinimumOperationsToConvertAllElementsToZero();
        System.out.println(app.minOperations(new int[]{4,4,7,4,3}));
    }

}
