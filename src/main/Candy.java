/**
 * 分发糖果：https://leetcode-cn.com/problems/candy/
 */
public class Candy {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        dp[0] = n == 1 || ratings[0] <= ratings[1] ? 1 : 2;
        for (int i = 1; i < n; i++) {
            dp[i] = ratings[i] > ratings[i - 1] ? dp[i - 1] + 1 : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[] {2,2,1})); // 4
        System.out.println(candy(new int[] {1,0,2})); // 5
        System.out.println(candy(new int[] {1,2,2})); // 4
        System.out.println(candy(new int[] {1,3,2,2,1})); // 7
        System.out.println(candy(new int[] {1,2,87,87,87,2,1})); // 13
        System.out.println(candy(new int[] {1,2,4,2,3})); // 9
        // [1,2,87,87,87,2,1]
        // 1 2 3 1 2 2 1

    }

}
