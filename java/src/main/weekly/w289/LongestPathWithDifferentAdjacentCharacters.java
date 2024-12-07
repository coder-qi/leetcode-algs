package weekly.w289;

import java.util.ArrayList;
import java.util.List;

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
        dfs(0);
        return ans;
    }

    private int dfs(int root) {
        if (children.get(root).isEmpty()) {
            return 1;
        }
        int first = 0, second = 0;
        for (int node : children.get(root)) {
            int childCount = dfs(node);
            ans = Math.max(ans, childCount);
            if (s.charAt(root) != s.charAt(node)) {
                if (childCount > second) {
                    first = second;
                    second = childCount;
                } else if (childCount > first) {
                    first = childCount;
                }
            }
        }
        ans = Math.max(ans, first + second + 1);
        return Math.max(first, second) + 1;
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
