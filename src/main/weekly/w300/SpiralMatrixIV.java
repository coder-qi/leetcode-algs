package weekly.w300;

import java.util.Arrays;

/**
 * 2326. 螺旋矩阵 IV：https://leetcode.cn/problems/spiral-matrix-iv/
 */
public class SpiralMatrixIV {

    static final int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int m, n;
    int[][] ans;
    ListNode head;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        this.m = m;
        this.n = n;
        this.head = head;
        ans = new int[m][n];
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], -1);
        }
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int row, int column, int p) {
        ans[row][column] = head.val;
        int nr = row + DIRS[p][0], nc = column + DIRS[p][1];
        if (nr < 0 || nr >= m || nc < 0 || nc >= n || ans[nr][nc] != -1) {
            p = (p + 1) % DIRS.length;
        }
        head = head.next;
        if (head != null) {
            dfs(row + DIRS[p][0], column + DIRS[p][1], p);
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

}
