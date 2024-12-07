import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水：https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static int trap_my(int[] height) {
        int maxIndex = 0, n = height.length;
        for (int i = 0, max = 0; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int ans = 0, max = height[0], index = 1;
        while (index <= maxIndex) {
            if (height[index] <= max) {
                ans += max - height[index];
            } else {
                max = height[index];
            }
            index++;
        }

        max = height[n - 1];
        index = n - 1;
        while (index >= maxIndex) {
            if (height[index] <= max) {
                ans += max - height[index];
            } else {
                max = height[index];
            }
            index--;
        }

        return ans;
    }

    /**
     * 动态规划：求出位置i左右两边所能达到的最大高度，该位置的节水量即为：min(leftMax[i], rightMax[i]) - height[i]
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int trap_dp(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 单调栈
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int trap_stack(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currHeight = Math.min(height[i], height[left]) - height[top];
                int currWidth = i - left - 1;
                ans += currHeight * currWidth;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 双指针
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public static int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(trap(new int[] {4,2,0,3,2,5})); // 9
        System.out.println(trap(new int[] {2,0,2})); // 2
    }

}
