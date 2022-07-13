import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 735. 行星碰撞：https://leetcode.cn/problems/asteroid-collision/
 */
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (!stack.isEmpty() && isSignDifference(stack.peek(), asteroids[i])) {
                while (!stack.isEmpty() && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; !stack.isEmpty(); i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private static boolean isSignDifference(int i, int j) {
        return (i > 0 && j < 0) || (i < 0 && j > 0);
    }

    public static void main(String[] args) {

    }

}
