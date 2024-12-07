import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数：https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        long n = numerator, d = denominator;
        if ((n < 0 && d > 0) || (n > 0 && d < 0)) {
            result.append('-');
        }
        n = Math.abs(n);
        d = Math.abs(d);
        result.append(n / d);
        long remainder = n % d;
        if (remainder == 0) {
            return result.toString();
        }
        result.append('.');

        StringBuilder factionPart = new StringBuilder();
        Map<Long, Integer> remainderIndexMap  = new HashMap<>();
        int index = 0;
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            factionPart.append(remainder / d);
            remainder %= d;
            index++;
        }
        if (remainder != 0) {
            int insertIndex = remainderIndexMap.get(remainder);
            factionPart.insert(insertIndex, '(');
            factionPart.append(')');
        }
        result.append(factionPart);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(7, -12));
        System.out.println(fractionToDecimal(-2147483648, -1));
        System.out.println(fractionToDecimal(-1, -2147483648));
        System.out.println(fractionToDecimal(-50, 8));
    }

}
