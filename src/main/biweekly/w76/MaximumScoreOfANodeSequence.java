package biweekly.w76;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 6063. 节点序列的最大得分：https://leetcode-cn.com/problems/maximum-score-of-a-node-sequence/
 */
public class MaximumScoreOfANodeSequence {

    List<List<Integer>> lists = new ArrayList<>();
    int ans = 0;

    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        int[] in = new int[n];
        for (int i = 0; i < edges.length; i++) {
            lists.get(edges[i][0]).add(edges[i][1]);
            lists.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] > 1) {
                //q.offer()
            }
        }
        return 0;
    }

    private void dfs(int v, int[] mark) {

    }

    public static void main(String[] args) {

    }

}
