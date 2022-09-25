import java.util.Arrays;

/**
 * 1397. 找到所有好字符串：https://leetcode.cn/problems/find-all-good-strings/
 */
public class FindAllGoodStrings {

    public static void main(String[] args) {
        System.out.println(new FindAllGoodStrings().findGoodStrings(2, "aa", "da", "b")); // 51
        System.out.println(new FindAllGoodStrings().findGoodStrings(8, "leetcode", "leetgoes", "leet")); // 0
        System.out.println(new FindAllGoodStrings().findGoodStrings(2, "gx", "gz", "x")); // 2
        System.out.println(new FindAllGoodStrings().findGoodStrings(8, "pzdanyao", "wgpmtywi", "sdka")); // 500543753
        System.out.println(new FindAllGoodStrings().findGoodStrings(72, "bcrsgwilmaoxgzxjigzzdkoswpinuynlgchavotsbqbznhylysbowlbdudeaejpacznptdrw",
            "wepelexcpqghwawbqcdymdwquvellmnrgehhmzodfaniewvnkxqeqslhunzleaupyscrqevm", "trnhqmpxkodcgstwlddldgdwuscaqnhcjptbsnrjmu")); // 993653529
    }

    static final int MOD = (int) (1e9 + 7);

    int[][][] memo = new int[500][50][4];
    int[][] statsMemo = new int[50][28];
    int n;
    char[] chars1, chars2;
    String evil;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        chars1 = s1.toCharArray();
        chars2 = s2.toCharArray();
        this.evil = evil;

        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 50; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        for (int i = 0; i < 50; i++) {
            Arrays.fill(statsMemo[i], -1);
        }
        return dfs(0, 3, 0);
    }

    private int dfs(int pos, int bound, int stats) {
        if (stats == evil.length()) {
            return 0;
        }
        if (pos == n) {
            return 1;
        }
        if (memo[pos][stats][bound] != -1) {
            return memo[pos][stats][bound];
        }
        int result = 0;
        char low = (bound & 1) != 0 ? chars1[pos] : 'a', up = (bound & 2) != 0 ? chars2[pos] : 'z';
        for (char c = low; c <= up; c++) {
            int nextBound = ((bound & 1) != 0 && chars1[pos] == c ? 1 : 0) | ((bound & 2) != 0 && chars2[pos] == c ? 2 : 0);
            int nextStats = getNextStats(stats, c);
            result += dfs(pos + 1, nextBound, nextStats);
            result %= MOD;
        }
        memo[pos][stats][bound] = result;

        return result;
    }

    private int getNextStats(int stats, char ch) {
        if (evil.charAt(stats) == ch) {
            return stats + 1;
        }
        if (statsMemo[stats][ch - 'a'] != -1) {
            return statsMemo[stats][ch - 'a'];
        }
        String s = evil.substring(0, stats) + ch;
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i);
            boolean matched = true;
            for (int j = 0; j < t.length(); j++) {
                if (evil.charAt(j) != t.charAt(j)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                statsMemo[stats][ch - 'a'] = t.length();
                return t.length();
            }
        }
        statsMemo[stats][ch - 'a'] = 0;
        return 0;
    }

}
