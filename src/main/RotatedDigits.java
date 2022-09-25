import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 788. 旋转数字：https://leetcode.cn/problems/rotated-digits/
 */
public class RotatedDigits {

    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(10)); // 4
        System.out.println(new RotatedDigits().rotatedDigits(10000)); // 2320
    }

    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    List<Integer> digits = new ArrayList<>();
    int[][][] memo = new int[5][2][2];

    public int rotatedDigits(int n) {
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        for (int i = 0; i < 5; i++) {
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
            if (check[i] != -1) {
                result += dfs(
                    pos + 1,
                    bound == 1 && i == digits.get(pos) ? 1 : 0,
                    diff == 1 || check[i] == 1 ? 1 : 0
                );
            }
        }
        memo[pos][bound][diff] = result;
        return result;
    }

}
