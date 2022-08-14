/**
 * 1422. 分割字符串的最大得分：https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 */
public class MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        System.out.println(maxScore("011101")); // 5
        System.out.println(maxScore("00111")); // 5
        System.out.println(maxScore("1111")); // 3
    }

    public static int maxScore(String s) {
        int n = s.length();
        int leftScore = 0, rightScore = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                rightScore++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftScore++;
            } else {
                rightScore--;
            }
            ans = Math.max(ans, leftScore + rightScore);
        }
        return ans;
    }

}
