import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 面试题 17.06. 2出现的次数：https://leetcode.cn/problems/number-of-2s-in-range-lcci/
 */
public class NumberOf2sInRangeLcci {

    public static void main(String[] args) {
        System.out.println(new NumberOf2sInRangeLcci().numberOf2sInRange(25));
    }

    List<Integer> digits = new ArrayList<>();
    int[][][] memo = new int[10][2][9];

    public int numberOf2sInRange(int n) {
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, 1, 0);
    }

    private int dfs(int pos, int bound, int diff) {
        if (pos == digits.size()) {
            return diff;
        }
        if (memo[pos][bound][diff] != -1) {
            return memo[pos][bound][diff];
        }
        int result = 0;
        for (int i = 0; i <= (bound == 1 ? digits.get(pos) : 9); i++) {
            result += dfs(
              pos + 1,
              bound == 1 && digits.get(pos) == i ? 1 : 0,
              i == 2 ? diff + 1 : diff
            );
        }
        memo[pos][bound][diff] = result;
        return result;
    }

}
