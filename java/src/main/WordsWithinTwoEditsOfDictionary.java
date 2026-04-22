import java.util.ArrayList;
import java.util.List;

/**
 * 2452. 距离字典两次编辑以内的单词：https://leetcode.cn/problems/words-within-two-edits-of-dictionary
 */
public class WordsWithinTwoEditsOfDictionary {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                int cnt = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        cnt++;
                        if (cnt > 2) {
                            break;
                        }
                    }
                }
                if (cnt <= 2) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }

}
