import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数：https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    static final Map<Character, Integer> symbols = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = symbols.get(s.charAt(i));
            if (i + 1 < s.length() && value < symbols.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV")); // 4
        System.out.println(romanToInt("IX")); // 9
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

}
