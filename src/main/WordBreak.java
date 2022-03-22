import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分：https://leetcode-cn.com/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int minWordLen = Integer.MAX_VALUE;
        int maxWordLen = Integer.MIN_VALUE;
        for (String word : wordDict) {
            minWordLen = Math.min(minWordLen, word.length());
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = minWordLen; i <= s.length(); i++) {
            for (int j = Math.max(0, i - maxWordLen); j <= i - minWordLen; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("applepenapple", "pen")));
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

}
