package team.spring2022;

import java.util.Arrays;

/**
 * LCP 56. 信物传送：https://leetcode-cn.com/problems/6UEx57/
 */
public class LCP56 {

    static final int[][] DIRS = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    int m, n;
    String[] matrix;
    int[] end;
    boolean[][] vis;
    int[][] mem;

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        this.matrix = matrix;
        this.end = end;

        m = matrix.length;
        n = matrix[0].length();
        vis = new boolean[m][n];
        mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }
        dfs(start[0], start[1], 0);
        return mem[end[0]][end[1]];
    }

    private void dfs(int row, int column, int operation) {
        if (row < 0 || row >= m || column < 0 || column >= n
                || vis[row][column]) {
            return;
        }
        if (operation >= mem[row][column] || operation >= mem[end[0]][end[1]]) {
            return;
        }
        if (row == end[0] && column == end[1]) {
            mem[end[0]][end[1]] = operation;
            return;
        }
        mem[row][column] = operation;

        vis[row][column] = true;
        int d = getDir(matrix[row].charAt(column));
        dfs(row + DIRS[d][0], column + DIRS[d][1], operation);
        for (int i = 0; i < 4; i++) {
            if (i == d) {
                continue;
            }
            dfs(row + DIRS[i][0], column + DIRS[i][1], operation + 1);
        }
        vis[row][column] = false;
    }

    private int getDir(char ch) {
        switch(ch) {
            case '^':
                return 0;
            case 'v':
                return 1;
            case '<':
                return 2;
            default:
                return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LCP56().conveyorBelt(new String[] {">>v","v^<","<><"},
            new int[] {0,1}, new int[] {2,0})); // 1
        System.out.println(new LCP56().conveyorBelt(new String[] {">>v",">>v","^<<"},
            new int[] {0,0}, new int[] {1,1})); // 0
        System.out.println(new LCP56().conveyorBelt(new String[] {">^^>","<^v>","^v^<"},
            new int[] {0,0}, new int[] {1,3})); // 3
    }

}
