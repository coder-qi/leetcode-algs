package weekly.w285;

import java.util.Arrays;

/**
 * 2212. 射箭比赛中的最大得分：https://leetcode.cn/problems/maximum-points-in-an-archery-competition/
 */
public class MaximumPointsInAnArcheryCompetition {

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int maxScore = 0;
        int state = 0;
        for (int i = 1; i < (1 << (n + 1)); i++) {
            int letNumArrows = numArrows;
            int score = 0;
            for (int j = 1; j < 12; j++) {
                if ((i & (1 << j)) != 0) {
                    letNumArrows -= aliceArrows[j] + 1;
                    if (letNumArrows < 0) {
                        score = -1;
                        break;
                    }
                    score +=j;
                }
            }
            if (score > maxScore) {
                state = i;
                maxScore = score;
            }
        }

        int letNumArrows = numArrows;
        int[] bobArrows = new int[n];
        for (int i = 1; i < 12; i++) {
            if ((state & (1 << i)) != 0) {
                bobArrows[i] = aliceArrows[i] + 1;
                letNumArrows -= bobArrows[i];
            }
        }
        bobArrows[0] = letNumArrows;
        return bobArrows;
    }

    public static void main(String[] args) {
        // [0,0,0,0,1,1,0,0,1,2,3,1]
        System.out.println(Arrays.toString(
            maximumBobPoints(9, new int[] {1,1,0,1,0,0,2,1,0,1,2,0})));
        // [0,0,0,0,0,0,0,0,1,1,1,0]
        System.out.println(Arrays.toString(
            maximumBobPoints(3, new int[] {0,0,1,0,0,0,0,0,0,0,0,2})));
        // [21,3,0,2,8,2,17,8,4,14,4,6]
        System.out.println(Arrays.toString(
            maximumBobPoints(89, new int[] {3,2,28,1,7,1,16,7,3,13,3,5})));
    }

}
