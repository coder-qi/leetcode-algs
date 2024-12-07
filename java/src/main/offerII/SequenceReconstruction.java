package offerII;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import static util.ArrayUtils.matrix;

/**
 * 剑指 Offer II 115. 重建序列：https://leetcode.cn/problems/ur2n8P/
 */
public class SequenceReconstruction {

    public static void main(String[] args) {
        System.out.println(sequenceReconstruction(new int[] {1,2,3}, matrix("[[1,2],[1,3]]")));
    }

    public static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            if (q.size() > 1) {
                return false;
            }
            int num = q.poll();
            for (int next : graph[num]) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return true;
    }

}
