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
    int[][][][] memo = new int[10][2][2][1 << 10];

    public int numDupDigitsAtMostN(int n) {
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        return dfs(0, 1, 1, 0, 0);
    }

    private int dfs(int pos, int bound, int leaderZero, int ok, int mask) {
        if (pos == digits.size()) {
            return leaderZero == 1 ? 0 : ok;
        }
        if (memo[pos][bound][ok][mask] != -1) {
            return memo[pos][bound][ok][mask];
        }
        int result = 0;
        if (leaderZero == 1) {
            result += dfs(pos + 1, 0, leaderZero, ok, mask);
        }
        int up = (bound == 1 ? digits.get(pos) : 9);
        for (int i = leaderZero; i <= up; i++) {
            boolean matched = (mask & (1 << i)) != 0;
            if (matched && bound == 0) {
                result += Math.pow(10, digits.size() - pos - 1);
            } else {
                result += dfs(
                    pos + 1,
                    bound == 1 && i == digits.get(pos) ? 1 : 0,
                    0,
                    ok == 1 || matched ? 1 : 0,
                    mask | (1 << i)
                );
            }
        }
        memo[pos][bound][ok][mask] = result;
        return result;
    }

}
