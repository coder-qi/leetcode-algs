import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiFunction;

/**
 * 最小覆盖子串：https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    private static BiFunction<Character, Integer, Integer> PLUS_ONE = (k, v) -> v == null ? 1 : v + 1;
    private static BiFunction<Character, Integer, Integer> MINUS_ONE = (k, v) -> v <= 1 ? null : v - 1;

    public static String minWindow(String s, String t) {
        Map<Character, Integer> ori = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ori.compute(t.charAt(i), PLUS_ONE);
        }

        Map<Character, Integer> cnt = new HashMap<>(ori);
        // 记录多余的字符数量
        Map<Character, Integer> extraCnt = new HashMap<>();
        // 记录有效字符的位置
        Queue<Integer> invalidPositions = new LinkedList<>();
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, resultLeft = -1, resultRight = -1;
        while (right < s.length()) {
            right++;
            if (right < s.length() && ori.containsKey(s.charAt(right))) {
                invalidPositions.add(right);
                removeCnt(cnt, extraCnt, s.charAt(right));
            }
            while (cnt.isEmpty() && !invalidPositions.isEmpty() && left <= right) {
                left = invalidPositions.remove();
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    resultLeft = left;
                    resultRight = left + len;
                }
                addCnt(cnt, extraCnt, s.charAt(left));
            }
        }
        return resultLeft == -1 ? "" : s.substring(resultLeft, resultRight);
    }

    private static void removeCnt(Map<Character, Integer> cnt, Map<Character, Integer> extraCnt, char c) {
        if (!cnt.containsKey(c)) {
            extraCnt.compute(c, PLUS_ONE);
        } else {
            cnt.compute(c, MINUS_ONE);
        }
    }

    private static void addCnt(Map<Character, Integer> cnt, Map<Character, Integer> extraCnt, char c) {
        if (extraCnt.containsKey(c)) {
            extraCnt.compute(c, MINUS_ONE);
        } else {
            cnt.compute(c, PLUS_ONE);
        }
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));; // BANC
    }

}
