/**
 * 整数转罗马数字：https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntegerToRoman {

    final static String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    final static int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String intToRomanSymbols(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (num >= nums[i]) {
                int m = num  / nums[i];
                for (int j = 0; j < m; j++) {
                    sb.append(strs[i]);
                }
                num -= m * nums[i];
            }
        }
        return sb.toString();
    }

    final static String[] thousands = {"", "M", "MM", "MMM"};
    final static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    final static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    final static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[num % 1000 / 100]);
        sb.append(tens[num % 100  / 10]);
        sb.append(ones[num % 10]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3)); // "III"
        System.out.println(intToRoman(4)); // "IV"
        System.out.println(intToRoman(9)); // "IX"
        System.out.println(intToRoman(58)); // "LVIII"
        System.out.println(intToRoman(1994)); // "MCMXCIV"
    }

}
