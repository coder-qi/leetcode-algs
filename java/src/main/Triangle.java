import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和：https://leetcode-cn.com/problems/triangle/
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4),
            Arrays.asList(6,5,7),
            Arrays.asList(4,1,8,3)
        )));
    }

}
