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
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], (key) -> 0);
            map.compute(words[i], (key, value) -> value != null ? value + 1 : 1);
        }

        List<Integer> ans = new ArrayList<>();
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
