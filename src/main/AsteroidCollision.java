import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 735. 行星碰撞：https://leetcode.cn/problems/asteroid-collision/
 */
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroids[i] < 0)
                    && Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                stack.pop();
            }
            if (stack.isEmpty() || !(stack.peek() > 0 && asteroids[i] < 0) ) {
                stack.push(asteroids[i]);
            } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                stack.pop();
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; !stack.isEmpty(); i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[] {5,10,-5}))); // [5,10]
    }

}
