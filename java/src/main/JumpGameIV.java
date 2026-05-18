import util.ArrayUtils;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV：https://leetcode.cn/problems/jump-game-iv
 */
public class JumpGameIV {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(arr[i], _ -> new ArrayList<>()).add(i);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int i = a[0];
            int cnt = a[1];
            if (i == n - 1) {
                return cnt;
            }
            if (i - 1 > 0 && !vis[i - 1]) {
                vis[i - 1] = true;
                q.offer(new int[] {i - 1, cnt + 1});
            }
            if (i + 1 < n && !vis[i + 1]) {
                vis[i + 1] = true;
                q.offer(new int[] {i + 1, cnt + 1});
            }
            for (int j : m.getOrDefault(arr[i], Collections.emptyList())) {
                if (!vis[j]) {
                    vis[j] = true;
                    q.offer(new int[] {j, cnt + 1});
                }
            }
            m.remove(arr[i]);
        }
        return n - 1;
    }
    public static void main() {
        JumpGameIV app = new JumpGameIV();
        System.out.println(app.minJumps(ArrayUtils.array("[7,6,9,6,9,6,9,7]")));
    }

}
