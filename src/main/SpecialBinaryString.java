import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制序列：https://leetcode.cn/problems/special-binary-string/
 */
public class SpecialBinaryString {

    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
    }

    public static String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        List<String> subStrings = new ArrayList<>();
        int count = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    subStrings.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }
        Collections.sort(subStrings, String.CASE_INSENSITIVE_ORDER.reversed());
        StringBuilder ans = new StringBuilder();
        for (String subString : subStrings) {
            ans.append(subString);
        }
        return ans.toString();
    }

}
