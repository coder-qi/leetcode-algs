package biweekly.w81;

import java.util.HashMap;
import java.util.Map;

import static util.ArrayUtils.matrix;

/**
 * 2316. 统计无向图中无法互相到达点对数：https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public static long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        Map<Integer, Integer> unionSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = uf.find(i);
            unionSize.put(p, unionSize.getOrDefault(p, 0) + 1);
        }
        long ans = 0;
        int count = 0;
        for (int size : unionSize.values()) {
            ans += size * (long)count;
            count += size;
        }
        return ans;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countPairs(3, matrix("[[0,1],[0,2],[1,2]]"))); // 0
        System.out.println(countPairs(7, matrix("[[0,2],[0,5],[2,4],[1,6],[5,4]]"))); // 14
    }

}
