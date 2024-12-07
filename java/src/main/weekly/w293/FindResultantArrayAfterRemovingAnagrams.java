package weekly.w293;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5234. 移除字母异位词后的结果数组：https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/
 */
public class FindResultantArrayAfterRemovingAnagrams {

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length;) {
            int j = i + 1;
            while (j < words.length && check(words[i], words[j])) {
                j++;
            }
            result.add(words[i]);
            i = j;
        }
        return result;
    }

    private static boolean check(String str1, String str2) {
        Map<Character, Integer> cnt1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            cnt1.put(str1.charAt(i), cnt1.getOrDefault(str1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> cnt2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            cnt2.put(str2.charAt(i), cnt2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        if (cnt1.size() != cnt2.size()) {
            return false;
        }
        for (char ch : cnt1.keySet()) {
            if (cnt1.getOrDefault(ch, 0) != cnt2.getOrDefault(ch, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"}));
    }

}
