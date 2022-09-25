import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1012. 至少有 1 位重复的数字：https://leetcode.cn/problems/numbers-with-repeated-digits/
 */
public class NumbersWithRepeatedDigits {

    public static void main(String[] args) {
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(20)); // 1
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(100)); // 10
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(1000)); // 262
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(98777)); // 66287
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(1000000000)); // 994388230
    }

    List<Integer> digits = new ArrayList<>();
    int[][][] memo = new int[10][2][1 << 10];

    public int numDupDigitsAtMostN(int n) {
        int t = n;
        while (t != 0) {
            digits.add(t % 10);
            t /= 10;
        }
        Collections.reverse(digits);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return n - dfs(0, 1, 1, 0);
    }

    private int dfs(int pos, int bound, int leaderZero, int mask) {
        if (pos == digits.size()) {
            return leaderZero == 1 ? 0 : 1;
        }
        if (memo[pos][bound][mask] != -1) {
            return memo[pos][bound][mask];
        }
        int result = 0;
        if (leaderZero == 1) {
            result += dfs(pos + 1, 0, leaderZero, mask);
        }
        int up = (bound == 1 ? digits.get(pos) : 9);
        for (int i = leaderZero; i <= up; i++) {
            if ((mask & (1 << i)) == 0) {
                result += dfs(
                    pos + 1,
                    bound == 1 && i == digits.get(pos) ? 1 : 0,
                    0,
                    mask | (1 << i)
                );
            }
        }
        memo[pos][bound][mask] = result;
        return result;
    }

}
