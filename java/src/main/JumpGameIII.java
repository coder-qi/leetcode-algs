import util.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1306. 跳跃游戏 III：https://leetcode.cn/problems/jump-game-iii
 */
public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        q.offer(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = true;
            if (arr[u] == 0) {
                return true;
            }
            if (u + arr[u] < n && !vis[u + arr[u]]) {
                q.offer(u + arr[u]);
            }
            if (u - arr[u] >= 0 && !vis[u - arr[u]]) {
                q.offer(u - arr[u]);
            }
        }
        return false;
    }

    public static void main() {
        JumpGameIII app = new JumpGameIII();
        System.out.println(app.canReach(ArrayUtils.array("[3,0,2,1,2]"), 2));
    }

}
