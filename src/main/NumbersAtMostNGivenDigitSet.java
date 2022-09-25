import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 902. 最大为 N 的数字组合：https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 */
public class NumbersAtMostNGivenDigitSet {

    public static void main(String[] args) {
        System.out.println(new NumbersAtMostNGivenDigitSet()
            .atMostNGivenDigitSet(new String[] {"1","3","5","7"}, 100)); // 20
        System.out.println(new NumbersAtMostNGivenDigitSet()
            .atMostNGivenDigitSet(new String[] {"1","4","9"}, 1000000000)); // 29523
    }

    int[] nums;
    List<Integer> list = new ArrayList<>();
    int[][][] memo = new int[10][2][2];

    public int atMostNGivenDigitSet(String[] digits, int n) {
        nums = new int[digits.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }

        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.reverse(list);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, 1, 0);
    }

    private int dfs(int pos, int bound, int diff) {
        if (pos == list.size()) {
            return diff;
        }
        if (memo[pos][bound][diff] != -1) {
            return memo[pos][bound][diff];
        }
        int result = 0;
        if (diff == 0) {
            result += dfs(pos + 1, 0, 0);
        }
        for (int num : nums) {
            if (bound == 0) {
                result += dfs(pos + 1, bound, 1);
            } else {
                if (num <= list.get(pos)) {
                    result += dfs(pos + 1, num == list.get(pos) ? 1 : 0, 1);
                }
            }
        }
        memo[pos][bound][diff] = result;
        return result;
    }

}
