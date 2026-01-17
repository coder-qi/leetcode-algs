import java.util.Arrays;
import java.util.List;

/**
 * 1301. 最大得分的路径数目：https://leetcode.cn/problems/number-of-paths-with-max-score
 */
public class NumberOfPathsWithMaxScore {

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }
        long[][][] memo = new long[n][m][];
        long[] ans = dfs(grid, n - 1, m - 1, memo);
        return ans[0] < 0 ? new int[] {0, 0} : new int[] {(int) (ans[0] % 1000000007), (int) ans[1]};
    }

    private long[] dfs(char[][] board, int i, int j, long[][][] memo) {
        if (i < 0 || j < 0 || board[i][j] == 'X') {
            return new long[] {Long.MIN_VALUE, 0};
        }
        if (i == 0 && j == 0) {
            return new long[] {0, 1};
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        long[] res1 = dfs(board, i - 1, j , memo);
        long[] res2 = dfs(board, i, j - 1 , memo);
        long[] res3 = dfs(board, i - 1, j - 1, memo);
        long maxScore = Math.max(res1[0], Math.max(res2[0], res3[0]));
        long cnt = 0;
        if (res1[0] == maxScore) {
            cnt += res1[1];
        }
        if (res2[0] == maxScore) {
            cnt += res2[1];
        }
        if (res3[0] == maxScore) {
            cnt += res3[1];
        }
        long score = board[i][j] >= '1' && board[i][j] <= '9' ? board[i][j] - '0' : 0;
        return memo[i][j] = new long[] {maxScore + score, cnt % 1000000007};
    }


    public int[] pathsWithMaxScore2(List<String> board) {
        int mod = (int) 1e9 + 7;
        int n = board.size();
        int m = board.get(0).length();
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }
        long[][] fCnt = new long[n + 1][m + 1];
        long[][] fScore = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            fScore[i][0] = Long.MIN_VALUE;
        }
        for (int j = 0; j <= m; j++) {
            fScore[0][j] = Long.MIN_VALUE;
        }
        fCnt[0][0] = 1;
        fScore[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i - 1][j - 1] == 'X') {
                    fScore[i][j] = Long.MIN_VALUE;
                    continue;
                }
                long maxScore = Math.max(fScore[i - 1][j], Math.max(fScore[i][j - 1], fScore[i - 1][j - 1]));
                long cnt = fScore[i - 1][j] == maxScore ? fCnt[i - 1][j] : 0;
                cnt += fScore[i][j - 1] == maxScore ? fCnt[i][j - 1] : 0;
                cnt += fScore[i - 1][j - 1] == maxScore ? fCnt[i - 1][j - 1] : 0;
                long score = grid[i - 1][j - 1] >= '1' && grid[i - 1][j - 1] <= '9' ? grid[i - 1][j - 1] - '0' : 0;
                fScore[i][j] = maxScore + score;
                fCnt[i][j] = cnt % mod;
            }
        }
        return fScore[n][m] < 0 ? new int[] {0, 0} : new int[] {(int) (fScore[n][m] % mod), (int) fCnt[n][m]};
    }

    public int[] pathsWithMaxScore3(List<String> board) {
        int mod = (int) 1e9 + 7;
        int n = board.size();
        int m = board.get(0).length();
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }
        long[] fCnt = new long[m + 1];
        long[] fScore = new long[m + 1];
        Arrays.fill(fScore, Long.MIN_VALUE);
        fScore[0] = 0;
        fCnt[0] = 1;
        for (int i = 1; i <= n; i++) {
            long preScore = Long.MIN_VALUE;
            long preCnt = 0;
            for (int j = 1; j <= m; j++) {
                long tmpScore = fScore[j];
                long tmpCnt = fCnt[j];
                if (grid[i - 1][j - 1] == 'X') {
                    fScore[j] = Long.MIN_VALUE;
                    fCnt[j] = 0;
                } else {
                    long maxScore = Math.max(fScore[j], Math.max(fScore[j - 1], preScore));
                    long cnt = 0;
                    if (fScore[j] == maxScore) cnt += fCnt[j];
                    if (fScore[j - 1] == maxScore) cnt += fCnt[j - 1];
                    if (preScore == maxScore) cnt += preCnt;

                    long score = (grid[i - 1][j - 1] >= '1' && grid[i - 1][j - 1] <= '9')
                            ? grid[i - 1][j - 1] - '0'
                            : 0;
                    fScore[j] = maxScore + score;
                    fCnt[j] = cnt % mod;
                }

                preScore = tmpScore;
                preCnt = tmpCnt;
            }
            fScore[0] = Long.MIN_VALUE;
            fCnt[0] = 0;
        }
        return fScore[m] < 0 ? new int[] {0, 0} : new int[] {(int) (fScore[m] % mod), (int) fCnt[m]};
    }

    public static void main(String[] args) {
        NumberOfPathsWithMaxScore app = new NumberOfPathsWithMaxScore();
        System.out.println(Arrays.toString(app.pathsWithMaxScore3(List.of("E23", "2X2", "12S"))));
    }

}
