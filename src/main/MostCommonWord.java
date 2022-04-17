import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. 最常见的单词：https://leetcode-cn.com/problems/most-common-word/
 */
public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String w : banned) {
            bannedSet.add(w);
        }
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.split("[!?',;. ]+");
        for (String word : words) {
            word = word.toLowerCase();
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        String result = null;
        int maxCnt = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord(
            "Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }

}
