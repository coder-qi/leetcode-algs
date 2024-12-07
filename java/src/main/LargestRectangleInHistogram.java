import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * 柱状图中最大的矩形：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[stack.peek()] > tmp[i]) {
                int h = tmp[stack.pop()];
                ans = Math.max(ans, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[] {2,4}));
        System.out.println(largestRectangleArea(new int[] {1,2,2}));
        System.out.println(largestRectangleArea(new int[] {1,2,3,4,5}));
        System.out.println(largestRectangleArea(new int[] {0,9}));
        System.out.println(largestRectangleArea(new int[] {1,1}));
        System.out.println(largestRectangleArea(new int[] {2,1,2}));
        System.out.println(largestRectangleArea(new int[] {4,2,0,3,2,5}));
        System.out.println(largestRectangleArea(new int[] {2,1,4,5,1,3,3}));
        System.out.println(largestRectangleArea(new int[] {4,2,0,3,2,4,3,4}));
    }

}
