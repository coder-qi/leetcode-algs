/**
 * 592. 分数加减运算：https://leetcode.cn/problems/fraction-addition-and-subtraction/
 */
public class FractionAdditionAndSubtraction {

    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2")); // "0/1"
        System.out.println(fractionAddition("-1/2+1/2+1/3")); // "1/3"
        System.out.println(fractionAddition("1/3-1/2")); // "-1/6"
    }

    public static String fractionAddition(String expression) {
        int p = 0, q = 1;
        if (expression.charAt(0) != '-') {
            expression = '+' + expression;
        }
        for (int i = 0; i < expression.length();) {
            int sign = 1;
            if (expression.charAt(i++) == '-') {
                sign = -1;
            }
            int a = 0;
            while (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                a = a * 10 + (expression.charAt(i) - '0');
                i++;
            }
            i++;
            int b = 0;
            while (i < expression.length() && expression.charAt(i) >= '0'
                    && expression.charAt(i) <= '9') {
                b = b * 10 + (expression.charAt(i) - '0');
                i++;
            }

            p = p * b + a * q * sign;
            q *= b;
        }
        int x = gcd(p, q);
        p /= x;
        q /= x;
        return (p * q < 0 ? "-" : "") + Math.abs(p) + "/" + Math.abs(q);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
