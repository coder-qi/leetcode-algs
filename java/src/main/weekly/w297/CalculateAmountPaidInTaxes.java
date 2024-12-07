package weekly.w297;

import util.ArrayUtils;

/**
 * 5259. 计算应缴税款总额：https://leetcode.cn/problems/calculate-amount-paid-in-taxes/
 */
public class CalculateAmountPaidInTaxes {

    public static double calculateTax(int[][] brackets, int income) {
        double ans = brackets[0][1] * Math.min(income, brackets[0][0]) / 100.0D;
        for (int i = 1; i < brackets.length; i++) {
            if (income <= brackets[i - 1][0]) {
                break;
            }
            ans += brackets[i][1] * Math.min(income - brackets[i - 1][0], brackets[i][0] - brackets[i - 1][0]) / 100.0D;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculateTax(ArrayUtils.matrix("[[3,50],[7,10],[12,25]]"), 10));
    }

}
