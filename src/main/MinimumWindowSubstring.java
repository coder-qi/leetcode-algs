import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
        int n = s.length(), begin = -1, end = -1;
        List<Integer> a = new LinkedList<>();
        Map<Character, Integer> tmp = new HashMap<>(chars);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (tmp.containsKey(c)) {
                tmp.compute(c, (k, v) -> v == 1 ? null : v - 1);
                a.add(i);
                if (tmp.isEmpty()) {
                    if (begin == -1) {
                        begin = a.get(0);
                        end = a.get(a.size() - 1);
                    } else if (i - a.get(0) < end - begin) {
                        begin = a.get(0);
                        end = i;
                    }
                    tmp.put(s.charAt(a.remove(0)), 1);
                }
            }
        }
        if (begin == -1) {
            return "";
        }
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));; // BANC
    }

}
