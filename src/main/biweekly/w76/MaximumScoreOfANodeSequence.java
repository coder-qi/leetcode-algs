package biweekly.w76;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 6063. 节点序列的最大得分：https://leetcode-cn.com/problems/maximum-score-of-a-node-sequence/
 */
public class MaximumScoreOfANodeSequence {


    public static int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[] {5,2,9,8,4}, new int[][]{
            {0,1},{1,2},{2,3},{0,2},{1,3},{2,4}
        }));
        System.out.println(maximumScore(new int[] {9,20,6,4,11,12}, new int[][]{
            {0,3},{5,3},{2,4},{1,3}
        }));
    }

}
