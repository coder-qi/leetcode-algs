import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串：https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            chars.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        int n = s.length(), begin = -1, end = n;
        Map<Character, Integer> tmp = new HashMap<>(chars);
        for (int i = 0; i < n; i++) {
            Integer cnt = tmp.get(s.charAt(i));
            if (cnt != null) {
                if (begin == -1) {
                    begin = i;
                }
                if (cnt == 1) {
                    tmp.remove(s.charAt(i));
                } else {
                    tmp.put(s.charAt(i), cnt - 1);
                }
                if (tmp.isEmpty()) {
                    if (i - begin < end - begin) {

                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        minWindow("", "aa");
    }

}
