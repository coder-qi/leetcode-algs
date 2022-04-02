import java.util.HashMap;
import java.util.LinkedHashMap;
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
        long remainder = Math.abs(n % d);
        if (remainder != 0) {
            result.append('.');
        }

        Map<Long, Long> map = new HashMap<>();
        Map<Long, StringBuilder> map2 = new LinkedHashMap<>();
        long prev = -1;
        while (remainder != 0) {
            if (map2.containsKey(remainder)) {
                map2.get(remainder).insert(0, '(');
                long cur = remainder;
                while (map.containsKey(cur)) {
                    cur = map.get(cur);
                }
                map2.get(cur).append(')');
                break;
            }
            StringBuilder sb = new StringBuilder();
            map2.put(remainder, sb);
            map.put(prev, remainder);
            prev = remainder;
            remainder *= 10;
            while (remainder < d) {
                remainder *= 10;
                sb.append('0');
            }
            sb.append(remainder / d);
            remainder %= d;
        }
        for (StringBuilder sb : map2.values()) {
            result.append(sb);
        }
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
