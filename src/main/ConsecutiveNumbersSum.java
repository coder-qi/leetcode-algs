/**
 * 829. 连续整数求和：https://leetcode.cn/problems/consecutive-numbers-sum/
 */
public class ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int k = 1; k * (k + 1) <= 2 * n; k++) {
            if (k % 2 == 1) {
                if (n % k == 0) {
                    ans++;
                }
            } else if (n % k != 0 && 2 * n % k == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5)); // 2
        System.out.println(consecutiveNumbersSum(9)); // 3
        System.out.println(consecutiveNumbersSum(15)); // 4
    }

}
