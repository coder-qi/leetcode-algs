import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringWithConcatenationOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), d = words[0].length(), m = d * words.length;
        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            wordMap.compute(words[i], (key, value) -> value != null ? value + 1 : 1);
        }

        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>(words.length);
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = i; j < i + m; j += d) {
                String w = s.substring(j, j + d);
                if (j == i) {
                    if (!wordMap.containsKey(w)) {
                        flag = false;
                        break;
                    }
                    countMap.putAll(wordMap);
                }
                Integer cnt = countMap.get(w);
                if (cnt == null) {
                    flag = false;
                    break;
                }
                if (cnt == 1) {
                    countMap.remove(w);
                } else {
                    countMap.put(w, cnt - 1);
                }
            }
            if (flag && countMap.isEmpty()) {
                ans.add(i);
            }
         }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo","bar"})); // [0, 9]
        System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo"})); // [3, 9]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"})); // []
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"})); // [6,9,12]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"})); // [8]
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] {"fooo","barr","wing","ding","wing"})); // [13]
    }

}
