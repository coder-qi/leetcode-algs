import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 648. 单词替换：https://leetcode.cn/problems/replace-words/
 */
public class ReplaceWords {

    public static String replaceWords(List<String> dictionary, String sentence) {
        Map<Integer, Set<String>> roots = new HashMap<>();
        for (String s : dictionary) {
            roots.compute(s.length(), (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(s);
                return v;
            });
        }
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            String replaceWord = word;
            for (Map.Entry<Integer, Set<String>> entry : roots.entrySet()) {
                int len = entry.getKey();
                if (word.length() > len) {
                    String s = word.substring(0, len);
                    if (entry.getValue().contains(s)) {
                        replaceWord = s;
                        break;
                    }
                }
            }
            ans.append(replaceWord).append(' ');
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceWords(
            Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(
            Arrays.asList("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }

}
