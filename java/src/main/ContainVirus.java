import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import static util.ArrayUtils.matrix;

/**
 * 749. 隔离病毒：https://leetcode.cn/problems/contain-virus/
 */
public class ContainVirus {

    static final int[][] DIRS = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        while (true) {
            List<Set<Integer>> neighbors = new ArrayList<>();
            List<Integer> firewalls =  new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] != 1) {
                        continue;
                    }
                    // 搜索所有的病毒区域
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    Set<Integer> neighbor = new HashSet<>();
                    int firewall = 0, index = neighbors.size() + 1;
                    isInfected[i][j] = -index;

                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int row = p[0], column = p[1];
                        for (int d = 0; d < DIRS.length; d++) {
                            int nr = row + DIRS[d][0], nc = column + DIRS[d][1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                                if (isInfected[nr][nc] == 1) {
                                    q.offer(new int[] {nr, nc});
                                    isInfected[nr][nc] = -index;
                                } else if (isInfected[nr][nc] == 0) {
                                    firewall++;
                                    neighbor.add(nr * n + nc);
                                }
                            }
                        }
                    }
                    neighbors.add(neighbor);
                    firewalls.add(firewall);
                }
            }

            if (neighbors.size() == 0) { // 全是病毒
                break;
            }

            // 找到需要设置防火墙最多的区域
            int index = 0;
            for (int i = 1; i < neighbors.size(); i++) {
                if (neighbors.get(i).size() > neighbors.get(index).size()) {
                    index = i;
                }
            }
            ans += firewalls.get(index);
            // 将设置了防火墙的病毒格子设为2，未设置防火墙的格子还原成1
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] == -index - 1) {
                            isInfected[i][j] = 2;
                        } else {
                            isInfected[i][j] = 1;
                        }
                    }
                }
            }
            // 未设置防火墙的格子向邻居扩散一波
            for (int i = 0; i < neighbors.size(); i++) {
                if (i != index) {
                    for (int val : neighbors.get(i)) {
                        int row = val / n, column = val % n;
                        isInfected[row][column] = 1;
                    }
                }
            }
            // 唯一的病毒区域也设置了防火墙了
            if (neighbors.size() == 1) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(containVirus(matrix("[[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]")));
    }

}
