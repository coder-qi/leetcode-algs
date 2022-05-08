package weekly.w292;

/**
 * 6058. 统计打字方案数：https://leetcode-cn.com/problems/count-number-of-texts/
 */
public class CountNumberOfTexts {

    static final int MOD = 1000000007;
    static final String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int[][] mem;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        mem = new int[4][n];

        long ans = 1;
        int left = 0;
        while (left < n) {
            int right = left + 1;
            while (right < n && pressedKeys.charAt(left) == pressedKeys.charAt(right)) {
                right++;
            }
            String letter = letters[pressedKeys.charAt(left) - '0' - 2];
            ans *= dfs(letter.length(), right - left);
            ans %= MOD;
            left = right;
        }
        return (int) ans;
    }

    private int dfs(int len, int count) {
        if (count <= 0) {
            return count == 0 ? 1 : 0;
        }
        if (mem[len - 1][count - 1] != 0) {
            return mem[len - 1][count - 1];
        }
        int result = 0;
        for (int i = 1; i <= len && i <= count; i++) {
            result += dfs(len, count - i);
            result %= MOD;
        }
        mem[len - 1][count - 1] = result;
        return result;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(new CountNumberOfTexts().countTexts("22233"));
        // 82876089
        System.out.println(new CountNumberOfTexts().countTexts("222222222222222222222222222222222222"));
        // 537551452
        System.out.println(new CountNumberOfTexts().countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
        // 886136986
        System.out.println(new CountNumberOfTexts().countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"));
    }

}
