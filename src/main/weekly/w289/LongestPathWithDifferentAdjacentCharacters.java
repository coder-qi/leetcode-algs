package weekly.w289;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 6073. 相邻字符不同的最长路径：https://leetcode-cn.com/problems/longest-path-with-different-adjacent-characters/
 */
public class LongestPathWithDifferentAdjacentCharacters {

    List<List<Integer>> children = new ArrayList<>();
    String s;
    int ans = 1;

    public int longestPath(int[] parent, String s) {
        this.s = s;
        for (int i = 0; i < parent.length; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            children.get(parent[i]).add(i);
        }
        return ans;
    }

    private int dfs(int root) {
        if (children.get(root).isEmpty()) {
            return 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int child : children.get(root)) {
            if (s.charAt(root) == s.charAt(child)) {
                continue;
            }
            int childLen = dfs(child);

        }
        return 0;
    }

    static int ans(int[] parent, String s) {
        return new LongestPathWithDifferentAdjacentCharacters().longestPath(parent, s);
    }

    public static void main(String[] args) {
        System.out.println(ans(new int[] {-1,0,0,1,1,2}, "abacbe"));
        System.out.println(ans(new int[] {-1,0,0,0}, "aabc"));
        System.out.println(ans(new int[] {-1}, "z"));
    }

}
