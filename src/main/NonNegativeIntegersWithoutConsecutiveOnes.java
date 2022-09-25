import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 600. 不含连续1的非负整数：https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(new NonNegativeIntegersWithoutConsecutiveOnes().findIntegers(5)); // 5
        System.out.println(new NonNegativeIntegersWithoutConsecutiveOnes().findIntegers(100000000)); // 514229
    }

    List<Integer> bits = new ArrayList<>();
    int[][][] memo = new int[31][2][2];

    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            bits.add(s.charAt(i) == '1' ? 1 : 0);
        }

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(0, 1, 0);
    }

    private int dfs(int pos, int bound, int diff) {
        if (diff == 2) {
            return 0;
        }
        if (pos == bits.size()) {
            return 1;
        }
        if (memo[pos][bound][diff] != -1) {
            return memo[pos][bound][diff];
        }
        int result = 0;
        for (int i = 0; i <= (bound == 1 ? bits.get(pos) : 1); i++) {
            result += dfs(
                pos + 1,
                bound == 1 && i == bits.get(pos) ? 1 : 0,
                i == 0 ? 0 : diff + 1
            );
        }
        memo[pos][bound][diff] = result;
        return result;
    }

}
