import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分 II：https://leetcode-cn.com/problems/word-break-ii/
 */
public class WordBreakII {

    Set<String> wordSet;
    List<String> result;
    StringBuilder sb;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);

        result = new ArrayList<>();
        sb = new StringBuilder();
        backtrace(s, 0);
        return result;
    }

    private void backtrace(String s, int begin) {
        if (begin >= s.length()) {
            result.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            String word = s.substring(begin, i + 1);
            if (wordSet.contains(word)) {
                sb.append(word).append(' ');
                backtrace(s, i + 1);
                sb.setLength(sb.length() - word.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("catsanddog",
            Arrays.asList("cat","cats","and","sand","dog")));
        System.out.println(new WordBreakII().wordBreak("pineapplepenapple",
            Arrays.asList("apple","pen","applepen","pine","pineapple")));
        System.out.println(new WordBreakII().wordBreak("catsandog",
            Arrays.asList("cats","dog","sand","and","cat")));
    }

}
