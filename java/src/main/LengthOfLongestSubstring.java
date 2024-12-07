import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
     * 检查字符在子字符串是否存在，不在字符串中则继续拼接到子字符串中
     * 存在则表示是无重复字符的最长子串了
     */
    public static int lengthOfLongestSubstring2(String s) {
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(String.valueOf(c));
            if (index == -1) {
                sb.append(c);
            } else {
                if (sb.length() > maxLength) {
                    maxLength = sb.length();
                }
                sb.setLength(0);
                i = start ++;
            }
        }
        if (sb.length() > maxLength) {
            maxLength = sb.length();
        }
        return maxLength;
    }

    /**
     * 使用map来进行查找（回退到重复字符处）
     */
    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index == null) {
                map.put(c, i);
                len++;
            } else {
                if (len > maxLength) { maxLength = len; }
                i = index;
                len = 0;
                map.clear();
            }
        }
        if (len > maxLength) { maxLength = len; }
        return maxLength;
    }

    /**
     *
     */
    public static int lengthOfLongestSubstring4(String s) {
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(String.valueOf(c));
            if (index != -1) {
                if (sb.length() > maxLength) {
                    maxLength = sb.length();
                }
                sb.delete(0, index + 1);
            }
            sb.append(c);
        }
        if (sb.length() > maxLength) { maxLength = sb.length(); }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = list.indexOf(c);
            if (index != -1) {
                maxLength = Math.max(list.size(), maxLength);
                for (int j = 0; j <= index; j++) {
                    list.removeFirst();
                }
            }
            list.add(c);
        }
        maxLength = Math.max(list.size(), maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab")); // 2
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring(" ")); // 1
    }

}
