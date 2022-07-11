import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 676. 实现一个魔法字典：https://leetcode.cn/problems/implement-magic-dictionary/
 */
public class ImplementMagicDictionary {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello", "leetcode"});
        magicDictionary.search("hello"); // 返回 False
        magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        magicDictionary.search("hell"); // 返回 False
        magicDictionary.search("leetcoded"); // 返回 False
    }

}

class MagicDictionary {

    Set<String> dict;
    Map<Integer, Set<Character>[]> charMap;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        dict = Set.of(dictionary);
        charMap = new HashMap<>();
        for (String s : dictionary) {
            Set<Character>[] chars = charMap.computeIfAbsent(s.length(), k -> new Set[s.length()]);
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] == null) {
                    chars[i] = new HashSet<>();
                }
                chars[i].add(s.charAt(i));
            }
        }
    }

    public boolean search(String searchWord) {
        Set<Character>[] chars = charMap.get(searchWord.length());
        if (chars == null) {
            return false;
        }
        for (int i = 0; i < searchWord.length(); i++) {
            for (char ch : chars[i]) {
                if (ch != searchWord.charAt(i)) {
                    String replaceWord = searchWord.substring(0, i) + ch;
                    if (searchWord.length() > 1) {
                        replaceWord += searchWord.substring(i + 1);
                    }
                    if (dict.contains(replaceWord)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
