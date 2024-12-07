import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 768. 最多能完成排序的块 II：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
public class MaxChunksToMakeSortedII {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[] {5,4,3,2,1})); // 1
        System.out.println(maxChunksToSorted(new int[] {2,1,3,4,4})); // 4
    }

    public static int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int max = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }

}
