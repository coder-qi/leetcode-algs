package weekly.w285;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2211. 统计道路上的碰撞次数：https://leetcode.cn/problems/count-collisions-on-a-road/
 */
public class CountCollisionsOnARoad {

    public static int countCollisions(String directions) {
        int ans = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < directions.length(); i++) {
            char dir = directions.charAt(i);
            if (stack.isEmpty()) {
                if (dir != 'L') {
                    stack.push(dir);
                }
            } else {
                switch (dir) {
                    case 'S':
                        while (!stack.isEmpty() && stack.peek() == 'R') {
                            stack.pop();
                            ans++;
                        }
                        stack.push(dir);
                        break;
                    case 'L':
                        if (stack.peek() == 'R') {
                            ans += 2;
                            stack.pop();
                            while (!stack.isEmpty() && stack.peek() == 'R') {
                                stack.pop();
                                ans++;
                            }
                            stack.push('S');
                        } else {
                            ans++;
                        }
                        break;
                    default: stack.push(dir);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL")); // 5
        System.out.println(countCollisions("LLRR")); // 0
    }

}
