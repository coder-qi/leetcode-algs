import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大矩形：https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    private int[] heights;
    private int[] newHeights;
    private Deque<Integer> stack;

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        heights = new int[n];
        newHeights = new int[n + 2];
        stack = new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            // 转换为求连续的矩形的最大面积
            ans = Math.max(ans, largestRectangleArea());
        }
        return ans;
    }

    private int largestRectangleArea() {
        int ans = 0;
        stack.clear();
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                ans = Math.max(ans, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix)); // 6

        char[][] matrix2 = {{'0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix2)); // 0

        char[][] matrix3 = {{'1'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix2)); // 1

        char[][] matrix4 = {{'0', '0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix4)); // 0
    }

}
