import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串：https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> ori = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> cnt = new HashMap<>(ori);
        // 记录多余的字符数量
        Map<Character, Integer> extraCnt = new HashMap<>();
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, resultLeft = -1, resultRight = -1;
        while (right < s.length()) {
            right++;
            if (right < s.length() && ori.containsKey(s.charAt(right))) {
                if (!cnt.containsKey(s.charAt(right))) {
                    extraCnt.put(s.charAt(right), extraCnt.getOrDefault(s.charAt(right), 0) + 1);
                } else {
                    if (cnt.get(s.charAt(right)) <= 1) {
                        cnt.remove(s.charAt(right));
                    } else {
                        cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) - 1);
                    }
                }
            }
            while (cnt.isEmpty() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    resultLeft = left;
                    resultRight = left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    if (extraCnt.containsKey(s.charAt(left))) {
                        if (extraCnt.get(s.charAt(left)) <= 1) {
                            extraCnt.remove(s.charAt(left));
                        } else {
                            extraCnt.put(s.charAt(left), extraCnt.getOrDefault(s.charAt(left), 0) - 1);
                        }
                    } else {
                        cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) + 1);
                    }
                }
                left++;
            }
        }

        return resultLeft == -1 ? "" : s.substring(resultLeft, resultRight);
    }

    private static boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));; // BANC
    }

}
