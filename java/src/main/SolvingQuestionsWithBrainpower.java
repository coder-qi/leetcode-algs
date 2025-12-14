/**
 * 2140. 解决智力问题：https://leetcode.cn/problems/solving-questions-with-brainpower
 */
public class SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        return dfs(questions, 0, memo);
    }

    private long dfs(int[][] questions, int i, long [] memo) {
        int n = questions.length;
        if (i >= n) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        int point = questions[i][0];
        int brainpower = questions[i][1];
        return memo[i] = Math.max(dfs(questions, i + 1, memo), point + dfs(questions, i + brainpower + 1, memo));
    }

    public long mostPoints2(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int brainpower = questions[i][1];
            f[i] = Math.max(f[i + 1], point + (i + brainpower + 1 <= n ? f[i + brainpower + 1] : 0));
        }
        return f[0];
    }

}
