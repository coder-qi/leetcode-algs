import java.util.ArrayList;
import java.util.List;

/**
 * 1417. 重新格式化字符串：https://leetcode.cn/problems/reformat-the-string/
 */
public class ReformatTheString {

    public static void main(String[] args) {

    }

    public static String reformat(String s) {
        List<Character> list1 = new ArrayList<>(s.length()),
            list2 = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                list1.add(ch);
            } else {
                list2.add(ch);
            }
        }
        int max = (s.length() + 1) / 2;
        if (list1.size() > max || list2.size() > max) {
            return "";
        }
        if (list2.size() > list1.size()) {
            List<Character> temp = list1;
            list1 = list2;
            list2 = temp;
        }

        StringBuilder ans = new StringBuilder(s.length());
        for (int i = 0; i < list1.size(); i++) {
            ans.append(list1.get(i));
            if (i < list2.size()) {
                ans.append(list2.get(i));
            }
        }
        return ans.toString();
    }

}
