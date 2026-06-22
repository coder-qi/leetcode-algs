/**
 * 1189. “气球” 的最大数量：https://leetcode.cn/problems/maximum-number-of-balloons
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[5];
        for (char ch : text.toCharArray()) {
            int idx;
            if (ch == 'a') {
                idx = 0;
            } else if (ch == 'b') {
                idx = 1;
            }  else if (ch == 'l') {
                idx = 2;
            } else if (ch == 'o') {
                idx = 3;
            } else if (ch == 'n') {
                idx = 4;
            } else {
                continue;
            }
            counts[idx]++;
        }
        return Math.min(counts[0], Math.min(counts[1],
                    Math.min(counts[2] / 2, Math.min(counts[3] / 2, counts[4]))));
    }

}
