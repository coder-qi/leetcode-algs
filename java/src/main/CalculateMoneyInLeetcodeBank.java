/**
 * 1716. 计算力扣银行的钱：https://leetcode.cn/problems/calculate-money-in-leetcode-bank
 */
public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int res = 0;
        for (int i = 1; i <= n / 7; i++) {
            res += (i + (i + 6)) * 7 / 2;
        }
        int remainder = n % 7;
        if (remainder != 0) {
            res += ((n / 7 + 1) * 2 + remainder - 1) * remainder / 2;
        }
        return res;
    }

}
