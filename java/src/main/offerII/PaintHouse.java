package offerII;

import static util.ArrayUtils.matrix;

/**
 * 剑指 Offer II 091. 粉刷房子：https://leetcode.cn/problems/JEj789/
 */
public class PaintHouse {

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int cost0 = costs[0][0], cost1 = costs[0][1], cost2 = costs[0][2];
        for (int i = 1; i < n; i++) {
            int c0 = cost0, c1 = cost1, c2 = cost2;
            cost0 = costs[i][0] + Math.min(c1, c2);
            cost1 = costs[i][1] + Math.min(c0, c2);
            cost2 = costs[i][2] + Math.min(c0, c1);
        }
        return Math.min(cost0, Math.min(cost1, cost2));
    }

    public static void main(String[] args) {
        System.out.println(minCost(matrix("[[17,2,17],[16,16,5],[14,3,19]]"))); // 10
        System.out.println(minCost(matrix("[[7,6,2]]"))); // 2
    }

}
