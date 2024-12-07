import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式：https://leetcode.cn/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<Character, Character> map = new HashMap<>();
            boolean matched = true;
            for (int j = 0; j < word.length(); j++) {
                if (!map.containsKey(pattern.charAt(j))) {
                    map.put(pattern.charAt(j), word.charAt(j));
                } else if (map.get(pattern.charAt(j)) != word.charAt(j)) {
                    matched = false;
                    break;
                }
            }
            if (matched && new HashSet<>(map.values()).size() == map.size()) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }

}
