import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分：https://leetcode-cn.com/problems/word-break/
 */
public class WordBreak {

    Set<String> wordSet;
    int[] mem;
    int minWordLen = Integer.MAX_VALUE;
    int maxWordLen = Integer.MIN_VALUE;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        for (String word : wordDict) {
            minWordLen = Math.min(minWordLen, word.length());
            maxWordLen = Math.max(maxWordLen, word.length());
        }
        mem = new int[s.length()];
        return backtrace(s, 0);
    }

    private boolean backtrace(String s, int begin) {
        if (begin >= s.length()) {
            return true;
        }
        if (mem[begin] != 0) {
            return mem[begin] == 1;
        }
        for (int i = begin + minWordLen - 1, end = Math.min(i + maxWordLen, s.length()); i < end; i++) {
            String word = s.substring(begin, i + 1);
            if (wordSet.contains(word) && backtrace(s, i + 1)) {
                mem[begin] = 1;
                return true;
            }
        }
        mem[begin] = -1;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("applepenapple", "pen")));
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

}
