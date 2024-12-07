/**
 * 3096. 得到更多分数的最少关卡数目：https://leetcode.cn/problems/minimum-levels-to-gain-more-points
 */
public class MinimumLevelsToGainMorePoints {

    public static int minimumLevels(int[] possible) {
        int sum = 0;
        for (int i = 0; i < possible.length; i++) {
            sum += possible[i] == 0 ? -1 : 1;
        }

        int aliceScore = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            aliceScore += possible[i] == 0 ? -1 : 1;
            int bobScore = sum - aliceScore;
            if (aliceScore > bobScore) {
                return i + 1;
            }
        }
        return -1;
    }

}
