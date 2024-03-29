import java.util.Arrays;

/**
 * 排列序列：https://leetcode-cn.com/problems/permutation-sequence/
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--;
        StringBuilder sb = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);

        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                if (order == 0) {
                    sb.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(3, 1));
        System.out.println(getPermutation(2, 2));
    }

}
