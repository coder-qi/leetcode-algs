import java.util.ArrayDeque;
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
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
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
